package espe.edu.sagnay_luis.model;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

=======
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
/**
 *
 * @author Luis Sagnay
 */
<<<<<<< HEAD
@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id 
    private int id_empleado;
    private String cargo;
    private float salario;
    private boolean activo;
=======
public class Empleado {
    private int id_empleado;
    private String cargo;
    private float salario;
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04

    public Empleado() {
    }

<<<<<<< HEAD
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
=======
    public Empleado(int id_empleado, String cargo, float salario) {
        this.id_empleado = id_empleado;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Empleado(String cargo, float salario) {
        this.cargo = cargo;
        this.salario = salario;
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
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
<<<<<<< HEAD
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
=======
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
}

