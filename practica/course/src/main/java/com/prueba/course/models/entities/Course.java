package com.prueba.course.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "courses")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre del curso es obligatorio")
    @Column(nullable = false)
    private String nombre;
    
    @NotNull(message = "Los créditos son obligatorios")
    @Positive(message = "Los créditos deben ser un número positivo")
    @Column(nullable = false)
    private Integer creditos;
    
    // Constructores
    public Course() {}
    
    public Course(String nombre, Integer creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    
   
}
    