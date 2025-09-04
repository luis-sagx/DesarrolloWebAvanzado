package com.sagnay.luis.ex3.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 127)
    private String titulo;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(nullable = false, length = 63)
    private String categoria;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridad prioridad = Prioridad.MEDIA;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.ABIERTO;
    
    @Column(name = "sla_horas", nullable = false)
    private Integer slaHoras;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
    
    @Column(name = "fecha_resolucion")
    private LocalDateTime fechaResolucion;

    public enum Prioridad {
        BAJA, MEDIA, ALTA, CRITICA
    }
    
    public enum Estado {
        ABIERTO, EN_PROGRESO, RESUELTO, CERRADO
    }

    // Constructors
    public Ticket() {}

    public Ticket(String titulo, String descripcion, String categoria, Prioridad prioridad, Integer slaHoras) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.slaHoras = slaHoras;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = LocalDateTime.now();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getSlaHoras() {
        return slaHoras;
    }

    public void setSlaHoras(Integer slaHoras) {
        this.slaHoras = slaHoras;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
