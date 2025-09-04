package com.sagnay.luis.ex3.models.dto;

import com.sagnay.luis.ex3.models.entities.Ticket;

public class TicketVencidoSlaDto {
    private Long id;
    private String titulo;
    private Ticket.Prioridad prioridad;
    private Ticket.Estado estado;
    private Integer slaHoras;
    private Long horasTranscurridas;

    public TicketVencidoSlaDto() {}

    public TicketVencidoSlaDto(Long id, String titulo, Ticket.Prioridad prioridad, 
                              Ticket.Estado estado, Integer slaHoras, Long horasTranscurridas) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.slaHoras = slaHoras;
        this.horasTranscurridas = horasTranscurridas;
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

    public Integer getSlaHoras() {
        return slaHoras;
    }

    public void setSlaHoras(Integer slaHoras) {
        this.slaHoras = slaHoras;
    }

    public Long getHorasTranscurridas() {
        return horasTranscurridas;
    }

    public void setHorasTranscurridas(Long horasTranscurridas) {
        this.horasTranscurridas = horasTranscurridas;
    }
}
