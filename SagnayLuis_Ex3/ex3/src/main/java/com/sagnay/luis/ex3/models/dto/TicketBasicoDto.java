package com.sagnay.luis.ex3.models.dto;

import com.sagnay.luis.ex3.models.entities.Ticket;
import java.time.LocalDateTime;

public class TicketBasicoDto {
    private Long id;
    private String titulo;
    private Ticket.Prioridad prioridad;
    private Ticket.Estado estado;
    private LocalDateTime fechaCreacion;

    public TicketBasicoDto() {}

    public TicketBasicoDto(Long id, String titulo, Ticket.Prioridad prioridad, Ticket.Estado estado, LocalDateTime fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Ticket.Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Ticket.Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Ticket.Estado getEstado() {
        return estado;
    }

    public void setEstado(Ticket.Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
