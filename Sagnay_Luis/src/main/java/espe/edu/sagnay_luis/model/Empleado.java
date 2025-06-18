package espe.edu.sagnay_luis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Luis Sagnay
 */
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 
    private int id_empleado;
    private String cargo;
    private float salario;
    private boolean activo;

    public Empleado() {
    }

    public Empleado(int id_empleado, String cargo, float salario, boolean activo) {
        this.id_empleado = id_empleado;
        this.cargo = cargo;
        this.salario = salario;
        this.activo = activo;
    }

    public Empleado(String cargo, float salario, boolean activo) {
        this.cargo = cargo;
        this.salario = salario;
        this.activo = activo;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

