package espe.edu.sagnay_luis.model;

/**
 *
 * @author Luis Sagnay
 */
public class HorarioTrabajo {
    private int idHorario;
    private String dia;
    private String horaEntrada;
    private String horaSalida;
    private int idEmpleado;

    public HorarioTrabajo() {}

    public HorarioTrabajo(int idHorario, String dia, String horaEntrada, String horaSalida, int idEmpleado) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
    }

    public HorarioTrabajo(String dia, String horaEntrada, String horaSalida, int idEmpleado) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}

