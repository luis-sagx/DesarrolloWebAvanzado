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
<<<<<<< HEAD
    private boolean activo;

    public HorarioTrabajo() {}

    public HorarioTrabajo(int idHorario, String dia, String horaEntrada, String horaSalida, int idEmpleado, boolean activo) {
=======

    public HorarioTrabajo() {}

    public HorarioTrabajo(int idHorario, String dia, String horaEntrada, String horaSalida, int idEmpleado) {
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
        this.idHorario = idHorario;
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
<<<<<<< HEAD
        this.activo = activo;
    }

    public HorarioTrabajo(String dia, String horaEntrada, String horaSalida, int idEmpleado, boolean activo) {
=======
    }

    public HorarioTrabajo(String dia, String horaEntrada, String horaSalida, int idEmpleado) {
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idEmpleado = idEmpleado;
<<<<<<< HEAD
        this.activo = activo;
=======
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
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

