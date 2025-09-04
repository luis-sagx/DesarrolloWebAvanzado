package com.sagnay.luis.ex3.controllers;

import com.sagnay.luis.ex3.models.dto.*;
import com.sagnay.luis.ex3.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    
    // Endpoint simple de prueba
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("API funcionando correctamente");
    }

    @GetMapping("/top-abiertos")
    public ResponseEntity<List<TicketBasicoDto>> getTicketsAbiertosPorPrioridad() {
        try {
            System.out.println("DEBUG: Iniciando consulta de tickets abiertos");
            List<TicketBasicoDto> tickets = ticketService.getTicketsAbiertosPorPrioridad();
            System.out.println("DEBUG: Se encontraron " + tickets.size() + " tickets");
            return ResponseEntity.ok(tickets);
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/estadisticas/por-estado")
    public ResponseEntity<List<EstadisticaEstadoDto>> getEstadisticasPorEstado() {
        try {
            List<EstadisticaEstadoDto> estadisticas = ticketService.getEstadisticasPorEstado();
            return ResponseEntity.ok(estadisticas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/vencidos-sla")
    public ResponseEntity<List<TicketVencidoSlaDto>> getTicketsVencidosSla(
            @RequestParam(defaultValue = "true") boolean soloActivos) {
        try {
            List<TicketVencidoSlaDto> tickets = ticketService.getTicketsVencidosSla(soloActivos);
            return ResponseEntity.ok(tickets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/estadisticas/tiempo-promedio")
    public ResponseEntity<List<TiempoPromedioDto>> getTiempoPromedioResolucionPorCategoria() {
        try {
            List<TiempoPromedioDto> estadisticas = ticketService.getTiempoPromedioResolucionPorCategoria();
            return ResponseEntity.ok(estadisticas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarTicketsPorTexto(@RequestParam String q) {
        try {
            List<TicketBasicoDto> tickets = ticketService.buscarTicketsPorTexto(q);
            return ResponseEntity.ok(tickets);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                .body(new ErrorResponse("El parámetro 'q' es obligatorio"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Error interno del servidor"));
        }
    }


    public static class ErrorResponse {
        private String error;
        public ErrorResponse(String error) {
            this.error = error;
        }
        public String getError() {
            return error;
        }
        public void setError(String error) {
            this.error = error;
        }
    }
}
