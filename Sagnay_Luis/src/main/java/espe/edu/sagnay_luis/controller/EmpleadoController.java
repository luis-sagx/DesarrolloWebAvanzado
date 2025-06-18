/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package espe.edu.sagnay_luis.controller;

import espe.edu.sagnay_luis.dao.EmpleadoDao;
import espe.edu.sagnay_luis.model.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Luis Sagnay
 */
@WebServlet(name = "EmpleadoController", urlPatterns = {"/empleado"})
public class EmpleadoController extends HttpServlet {

    private final EmpleadoDao empleadoDao = new EmpleadoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");
        if (option == null) option = "findAll";

        switch (option) {
            case "new":
                request.getRequestDispatcher("/formEmpleado.jsp").forward(request, response);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Empleado emp = empleadoDao.findById(id);
                request.setAttribute("empleado", emp);
                request.getRequestDispatcher("/formEmpleado.jsp").forward(request, response);
                break;
            case "delete":
                int idDel = Integer.parseInt(request.getParameter("id"));
                empleadoDao.delete(idDel);
                response.sendRedirect("empleado");
                break;
            default:
                List<Empleado> empleados = empleadoDao.findAll();
                request.setAttribute("empleados", empleados);
                request.getRequestDispatcher("/listEmpleado.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id_empleado");
        String cargo = request.getParameter("cargo");
        float salario = Float.parseFloat(request.getParameter("salario"));

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
<<<<<<< HEAD
            Empleado e = new Empleado(id, cargo, salario, true);
            empleadoDao.update(e);
        } else {
            Empleado e = new Empleado(cargo, salario, true);
=======
            Empleado e = new Empleado(id, cargo, salario);
            empleadoDao.update(e);
        } else {
            Empleado e = new Empleado(cargo, salario);
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
            empleadoDao.save(e);
        }

        response.sendRedirect("empleado");
    }
}

