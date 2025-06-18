/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package espe.edu.examen_sagnay_luis.soap;

import espe.edu.examen_sagnay_luis.dao.HotelDao;
import espe.edu.examen_sagnay_luis.model.Hotel;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Luis Sagnay
 */

@WebService
public class HotelService {
    private final HotelDao hotelDao = new HotelDao();

    @WebMethod
    public List<Hotel> listarHoteles() {
        return hotelDao.findAll(); 
    }

    @WebMethod
    public boolean insertarHotel(String nombre, String categoria, int totalHabitaciones, float avaluo, Date fecha, Time hora) {
        Hotel nuevo = new Hotel(nombre, categoria, totalHabitaciones, avaluo, fecha, hora, true);
        return hotelDao.save(nuevo);
    }

}
