package com.sagnay.luis.ex3.services;

import com.sagnay.luis.ex3.models.dto.*;
import com.sagnay.luis.ex3.models.entities.Ticket;
import com.sagnay.luis.ex3.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    
    public long countAllTickets() {
        return ticketRepository.count();
    }

    public List<TicketBasicoDto> getTicketsAbiertosPorPrioridad() {
        System.out.println("DEBUG: Consultando tickets en estado ABIERTO");
        try {
            List<Ticket> tickets = ticketRepository.findByEstadoOrderByPrioridadAscFechaCreacionAsc(Ticket.Estado.ABIERTO);
            System.out.println("DEBUG: Query ejecutada, se encontraron " + tickets.size() + " tickets");
            
            // Convertir a DTO y aplicar ordenación personalizada por prioridad
            return tickets.stream()
                .map(this::convertToTicketBasicoDto)
                .sorted((t1, t2) -> {
                    // Ordenar por prioridad: CRITICA=1, ALTA=2, MEDIA=3, BAJA=4
                    int prioridadOrder1 = getPrioridadOrder(t1.getPrioridad());
                    int prioridadOrder2 = getPrioridadOrder(t2.getPrioridad());
                    
                    int prioridadComparison = Integer.compare(prioridadOrder1, prioridadOrder2);
                    if (prioridadComparison != 0) {
                        return prioridadComparison;
                    }
                    
                    // Si la prioridad es igual, ordenar por fecha de creación ascendente
                    return t1.getFechaCreacion().compareTo(t2.getFechaCreacion());
                })
                .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("ERROR en getTicketsAbiertosPorPrioridad: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
    
    private int getPrioridadOrder(Ticket.Prioridad prioridad) {
        return switch (prioridad) {
            case CRITICA -> 1;
            case ALTA -> 2;
            case MEDIA -> 3;
            case BAJA -> 4;
        };
    }
    
    private TicketBasicoDto convertToTicketBasicoDto(Ticket ticket) {
        return new TicketBasicoDto(
            ticket.getId(),
            ticket.getTitulo(),
            ticket.getPrioridad(),
            ticket.getEstado(),
            ticket.getFechaCreacion()
        );
    }

    public List<EstadisticaEstadoDto> getEstadisticasPorEstado() {
        return ticketRepository.countTicketsByEstado();
    }

    public List<TicketVencidoSlaDto> getTicketsVencidosSla(boolean soloActivos) {
        List<Ticket> tickets;
        
        if (soloActivos) {
            // Solo tickets ABIERTO y EN_PROGRESO
            tickets = ticketRepository.findByEstadoInOrderByFechaCreacionAsc(
                Arrays.asList(Ticket.Estado.ABIERTO, Ticket.Estado.EN_PROGRESO)
            );
        } else {
            // Todos los tickets
            tickets = ticketRepository.findAllByOrderByFechaCreacionAsc();
        }
        
        LocalDateTime now = LocalDateTime.now();
        
        return tickets.stream()
            .filter(ticket -> {
                long horasTranscurridas = Duration.between(ticket.getFechaCreacion(), now).toHours();
                return horasTranscurridas > ticket.getSlaHoras();
            })
            .map(ticket -> {
                long horasTranscurridas = Duration.between(ticket.getFechaCreacion(), now).toHours();
                return new TicketVencidoSlaDto(
                    ticket.getId(),
                    ticket.getTitulo(),
                    ticket.getPrioridad(),
                    ticket.getEstado(),
                    ticket.getSlaHoras(),
                    horasTranscurridas
                );
            })
            .sorted((t1, t2) -> Long.compare(t2.getHorasTranscurridas(), t1.getHorasTranscurridas()))
            .collect(Collectors.toList());
    }

    public List<TiempoPromedioDto> getTiempoPromedioResolucionPorCategoria() {
        List<Ticket> ticketsResueltos = ticketRepository.findByFechaResolucionIsNotNullOrderByCategoriaAsc();
        
        Map<String, Double> promediosPorCategoria = ticketsResueltos.stream()
            .collect(Collectors.groupingBy(
                Ticket::getCategoria,
                Collectors.averagingLong(ticket -> 
                    Duration.between(ticket.getFechaCreacion(), ticket.getFechaResolucion()).toHours()
                )
            ));
        
        return promediosPorCategoria.entrySet().stream()
            .map(entry -> {
                String categoria = entry.getKey();
                Double horasPromedio = Math.round(entry.getValue() * 10.0) / 10.0;
                return new TiempoPromedioDto(categoria, horasPromedio);
            })
            .sorted((t1, t2) -> Double.compare(t1.getHorasPromedio(), t2.getHorasPromedio()))
            .collect(Collectors.toList());
    }

    public List<TicketBasicoDto> buscarTicketsPorTexto(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("El parámetro de búsqueda 'q' es obligatorio");
        }
        
        String searchQuery = query.trim();
        List<Ticket> tickets = ticketRepository
            .findByTituloContainingIgnoreCaseOrDescripcionContainingIgnoreCaseOrderByFechaCreacionDesc(
                searchQuery, searchQuery
            );
        
        return tickets.stream()
            .map(this::convertToTicketBasicoDto)
            .collect(Collectors.toList());
    }
}
