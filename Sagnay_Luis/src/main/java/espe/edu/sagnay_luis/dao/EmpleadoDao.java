/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.sagnay_luis.dao;

import espe.edu.sagnay_luis.model.Empleado;
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
public class EmpleadoDao {

    public boolean save(Empleado e) {
        String sql = "INSERT INTO Empleado (cargo, salario) VALUES (?, ?)";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getCargo());
            stmt.setFloat(2, e.getSalario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Empleado> findAll() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId_empleado(rs.getInt("id_empleado"));
                e.setCargo(rs.getString("cargo"));
                e.setSalario(rs.getFloat("salario"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Empleado findById(int id) {
        String sql = "SELECT * FROM Empleado WHERE id_empleado = ?";
        Empleado e = null;
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                e = new Empleado();
                e.setId_empleado(rs.getInt("id_empleado"));
                e.setCargo(rs.getString("cargo"));
                e.setSalario(rs.getFloat("salario"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public boolean update(Empleado e) {
        String sql = "UPDATE Empleado SET cargo = ?, salario = ? WHERE id_empleado = ?";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getCargo());
            stmt.setFloat(2, e.getSalario());
            stmt.setInt(3, e.getId_empleado());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Empleado WHERE id_empleado = ?";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}