package com.sagnay.luis.ex3.models.dto;

import com.sagnay.luis.ex3.models.entities.Ticket;

public class EstadisticaEstadoDto {
    private Ticket.Estado estado;
    private Long total;

    public EstadisticaEstadoDto() {}

    public EstadisticaEstadoDto(Ticket.Estado estado, Long total) {
        this.estado = estado;
        this.total = total;
    }

    // Getters and Setters
    public Ticket.Estado getEstado() {
        return estado;
    }

    public void setEstado(Ticket.Estado estado) {
        this.estado = estado;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
