/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.examen_sagnay_luis.dao;
import espe.edu.examen_sagnay_luis.model.Hotel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Sagnay
 */
public class HotelDao {

    public boolean save(Hotel hotel) {
        String sql = "INSERT INTO Hotel (nombre, categoria, total_habitaciones, avaluo, fecha, hora, activo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hotel.getNombre());
            stmt.setString(2, hotel.getCategoria());
            stmt.setInt(3, hotel.getTotalHabitaciones());
            stmt.setFloat(4, hotel.getAvaluo());
            stmt.setDate(5, (Date) hotel.getFecha());
            stmt.setTime(6, hotel.getHora());
            stmt.setBoolean(7, true);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Hotel> findAll() {
        List<Hotel> hoteles = new ArrayList<>();
        String sql = "SELECT * FROM Hotel WHERE activo = TRUE";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(rs.getInt("id"));
                hotel.setNombre(rs.getString("nombre"));
                hotel.setCategoria(rs.getString("categoria"));
                hotel.setTotalHabitaciones(rs.getInt("total_habitaciones"));
                hotel.setAvaluo(rs.getFloat("avaluo"));
                hotel.setFecha(rs.getDate("fecha"));
                hotel.setHora(rs.getTime("hora"));
                hotel.setActivo(rs.getBoolean("activo"));
                hoteles.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoteles;
    }

    public Hotel findById(int id) {
        Hotel hotel = null;
        String sql = "SELECT * FROM Hotel WHERE id = ?";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    hotel = new Hotel();
                    hotel.setId(rs.getInt("id"));
                    hotel.setNombre(rs.getString("nombre"));
                    hotel.setCategoria(rs.getString("categoria"));
                    hotel.setTotalHabitaciones(rs.getInt("total_habitaciones"));
                    hotel.setAvaluo(rs.getFloat("avaluo"));
                    hotel.setFecha(rs.getDate("fecha"));
                    hotel.setHora(rs.getTime("hora"));
                    hotel.setActivo(rs.getBoolean("activo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    public boolean update(Hotel hotel) {
        String sql = "UPDATE Hotel SET nombre = ?, categoria = ?, total_habitaciones = ?, avaluo = ?, fecha = ?, hora = ? WHERE id = ?";
        try (Connection conn = Conection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hotel.getNombre());
            stmt.setString(2, hotel.getCategoria());
            stmt.setInt(3, hotel.getTotalHabitaciones());
            stmt.setFloat(4, hotel.getAvaluo());
            stmt.setDate(5, (Date) hotel.getFecha());
            stmt.setTime(6, hotel.getHora());
            stmt.setInt(7, hotel.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "UPDATE Hotel SET activo = FALSE WHERE id = ?";
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
