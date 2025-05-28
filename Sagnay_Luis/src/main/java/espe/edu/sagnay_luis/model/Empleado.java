package espe.edu.sagnay_luis.model;

/**
 *
 * @author Luis Sagnay
 */
public class Empleado {
    private int id_empleado;
    private String cargo;
    private float salario;

    public Empleado() {
    }

    public Empleado(int id_empleado, String cargo, float salario) {
        this.id_empleado = id_empleado;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Empleado(String cargo, float salario) {
        this.cargo = cargo;
        this.salario = salario;
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
}

