package espe.edu.sagnay_luis.dao;

import espe.edu.sagnay_luis.model.HorarioTrabajo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Sagnay
 */
public class HorarioTrabajoDao {

    public boolean save(HorarioTrabajo horario) {
        String sql = "INSERT INTO HorarioTrabajo (dia, hora_entrada, hora_salida, id_empleado) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horario.getDia());
            stmt.setString(2, horario.getHoraEntrada());
            stmt.setString(3, horario.getHoraSalida());
            stmt.setInt(4, horario.getIdEmpleado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<HorarioTrabajo> findAll() {
        List<HorarioTrabajo> lista = new ArrayList<>();
<<<<<<< HEAD
        String sql = "SELECT h.* FROM HorarioTrabajo h JOIN Empleado e ON h.id_empleado = e.id_empleado WHERE h.activo = TRUE AND e.activo = TRUE";
=======
        String sql = "SELECT * FROM HorarioTrabajo";
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                HorarioTrabajo h = new HorarioTrabajo();
                h.setIdHorario(rs.getInt("id_horario"));
                h.setDia(rs.getString("dia"));
                h.setHoraEntrada(rs.getString("hora_entrada"));
                h.setHoraSalida(rs.getString("hora_salida"));
                h.setIdEmpleado(rs.getInt("id_empleado"));
<<<<<<< HEAD
                h.setActivo(rs.getBoolean("activo"));
=======
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
                lista.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public HorarioTrabajo findById(int id) {
        String sql = "SELECT * FROM HorarioTrabajo WHERE id_horario = ?";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                HorarioTrabajo h = new HorarioTrabajo();
                h.setIdHorario(rs.getInt("id_horario"));
                h.setDia(rs.getString("dia"));
                h.setHoraEntrada(rs.getString("hora_entrada"));
                h.setHoraSalida(rs.getString("hora_salida"));
                h.setIdEmpleado(rs.getInt("id_empleado"));
                return h;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(HorarioTrabajo horario) {
        String sql = "UPDATE HorarioTrabajo SET dia = ?, hora_entrada = ?, hora_salida = ?, id_empleado = ? WHERE id_horario = ?";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horario.getDia());
            stmt.setString(2, horario.getHoraEntrada());
            stmt.setString(3, horario.getHoraSalida());
            stmt.setInt(4, horario.getIdEmpleado());
            stmt.setInt(5, horario.getIdHorario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
<<<<<<< HEAD
        String sql = "UPDATE HorarioTrabajo SET activo = FALSE WHERE id_horario = ?";
=======
        String sql = "DELETE FROM HorarioTrabajo WHERE id_horario = ?";
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}