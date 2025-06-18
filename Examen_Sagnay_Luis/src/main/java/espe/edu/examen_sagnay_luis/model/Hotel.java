/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.examen_sagnay_luis.model;

/**
 *
 * @author Luis Sagnay
 */

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

import java.sql.Time;

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String categoria;
    private int totalHabitaciones;
    private float avaluo;
    private Date fecha;
    private Time hora;
    private boolean activo;

    public Hotel() {}

    public Hotel(int id, String nombre, String categoria, int totalHabitaciones, float avaluo, Date fecha, Time hora, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.totalHabitaciones = totalHabitaciones;
        this.avaluo = avaluo;
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
    }

    public Hotel(String nombre, String categoria, int totalHabitaciones, float avaluo, Date fecha, Time hora, boolean activo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.totalHabitaciones = totalHabitaciones;
        this.avaluo = avaluo;
        this.fecha = fecha;
        this.hora = hora;
        this.activo = activo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTotalHabitaciones() {
        return totalHabitaciones;
    }

    public void setTotalHabitaciones(int totalHabitaciones) {
        this.totalHabitaciones = totalHabitaciones;
    }

    public float getAvaluo() {
        return avaluo;
    }

    public void setAvaluo(float avaluo) {
        this.avaluo = avaluo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

 }
