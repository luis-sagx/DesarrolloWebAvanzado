/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package espe.edu.examen_sagnay_luis.controller;

import espe.edu.examen_sagnay_luis.dao.HotelDao;
import espe.edu.examen_sagnay_luis.model.Hotel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Luis Sagnay
 */
@WebServlet(name = "HotelController", urlPatterns = {"/hotel"})
public class HotelController extends HttpServlet {

    private final HotelDao hotelDao = new HotelDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");

        if (option == null) option = "findAll";

        switch (option) {
            case "new":
                request.getRequestDispatcher("/formHotel.jsp").forward(request, response);
                break;

            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Hotel hotel = hotelDao.findById(id);
                request.setAttribute("hotel", hotel);
                request.getRequestDispatcher("/formHotel.jsp").forward(request, response);
                break;

            case "delete":
                int idDel = Integer.parseInt(request.getParameter("id"));
                hotelDao.delete(idDel);
                response.sendRedirect("hotel");
                break;

            default:
                List<Hotel> hoteles = hotelDao.findAll();
                request.setAttribute("hoteles", hoteles);
                request.getRequestDispatcher("/listHotel.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        String idStr = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        int totalHabitaciones = Integer.parseInt(request.getParameter("totalHabitaciones"));
        float avaluo = Float.parseFloat(request.getParameter("avaluo"));

        Date fecha = Date.valueOf(request.getParameter("fecha")); 
        Time hora = Time.valueOf(request.getParameter("hora") + ":00"); 

        Hotel hotel = new Hotel();
        hotel.setNombre(nombre);
        hotel.setCategoria(categoria);
        hotel.setTotalHabitaciones(totalHabitaciones);
        hotel.setAvaluo(avaluo);
        hotel.setFecha(fecha);
        hotel.setHora(hora);
        hotel.setActivo(true);

        if (idStr != null && !idStr.isEmpty()) {
            hotel.setId(Integer.parseInt(idStr));
            hotelDao.update(hotel);
        } else {
            hotelDao.save(hotel);
        }

        response.sendRedirect("hotel");
        } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException(e); 
    }
    }

}
