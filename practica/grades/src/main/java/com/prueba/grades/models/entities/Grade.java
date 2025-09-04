package com.prueba.grades.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "grades")
public class Grade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "El ID del estudiante es obligatorio")
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    
    @NotNull(message = "El ID del curso es obligatorio")
    @Column(name = "course_id", nullable = false)
    private Long courseId;
    
    @NotNull(message = "La nota es obligatoria")
    @DecimalMin(value = "0.0", message = "La nota debe ser mayor o igual a 0")
    @DecimalMax(value = "10.0", message = "La nota debe ser menor o igual a 10")
    @Column(nullable = false)
    private Double nota;
    
    // Constructores
    public Grade() {}
    
    public Grade(Long studentId, Long courseId, Double nota) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.nota = nota;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getStudentId() {
        return studentId;
    }
    
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    
    public Long getCourseId() {
        return courseId;
    }
    
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
    
    public Double getNota() {
        return nota;
    }
    
    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    // toString, equals y hashCode
    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", nota=" + nota +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Grade grade = (Grade) o;
        
        return id != null ? id.equals(grade.id) : grade.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
