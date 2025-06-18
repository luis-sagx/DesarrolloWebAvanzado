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
    private boolean activo;

    public HorarioTrabajo() {}

    public HorarioTrabajo(int idHorario, String dia, String horaEntrada, String horaSalida, int idEmpleado, boolean activo) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
        this.activo = activo;
    }

    public HorarioTrabajo(String dia, String horaEntrada, String horaSalida, int idEmpleado, boolean activo) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
        this.activo = activo;
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
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

