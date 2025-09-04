package com.sagnay.luis.ex3.repositories;

import com.sagnay.luis.ex3.models.entities.Ticket;
import com.sagnay.luis.ex3.models.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByEstadoOrderByPrioridadAscFechaCreacionAsc(Ticket.Estado estado);

    @Query("SELECT new com.sagnay.luis.ex3.models.dto.EstadisticaEstadoDto(t.estado, COUNT(t)) FROM Ticket t GROUP BY t.estado")
    List<EstadisticaEstadoDto> countTicketsByEstado();

    List<Ticket> findByEstadoInOrderByFechaCreacionAsc(List<Ticket.Estado> estados);
    
    List<Ticket> findAllByOrderByFechaCreacionAsc();

    List<Ticket> findByFechaResolucionIsNotNullOrderByCategoriaAsc();

    List<Ticket> findByTituloContainingIgnoreCaseOrDescripcionContainingIgnoreCaseOrderByFechaCreacionDesc(
        String titulo, String descripcion);
}
