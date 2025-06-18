package espe.edu.sagnay_luis.controller;

import espe.edu.sagnay_luis.dao.EmpleadoDao;
import espe.edu.sagnay_luis.dao.HorarioTrabajoDao;
import espe.edu.sagnay_luis.model.Empleado;
import espe.edu.sagnay_luis.model.HorarioTrabajo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luis Sagnay
 */
@WebServlet(name = "HorarioController", urlPatterns = {"/horario"})
public class HorarioController extends HttpServlet {
    private final HorarioTrabajoDao dao = new HorarioTrabajoDao();
    private final EmpleadoDao empleadoDao = new EmpleadoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");
        if (option == null) option = "findAll";

        switch (option) {
            case "new":
                request.setAttribute("empleados", empleadoDao.findAll());
                request.getRequestDispatcher("/formHorario.jsp").forward(request, response);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                HorarioTrabajo horario = dao.findById(id);
                request.setAttribute("horario", horario);
                request.setAttribute("empleados", empleadoDao.findAll());
                request.getRequestDispatcher("/formHorario.jsp").forward(request, response);
                break;
            case "delete":
                int idDelete = Integer.parseInt(request.getParameter("id"));
                dao.delete(idDelete);
                response.sendRedirect("horario");
                break;
            default:
                List<HorarioTrabajo> horarios = dao.findAll();
                List<Empleado> empleados = empleadoDao.findAll();

                // Mapa para acceso rápido por ID
                Map<Integer, String> mapaEmpleados = new HashMap<>();
                for (Empleado e : empleados) {
                    mapaEmpleados.put(e.getId_empleado(), e.getCargo());
                }

                request.setAttribute("horarios", horarios);
                request.setAttribute("mapaEmpleados", mapaEmpleados);
                request.getRequestDispatcher("/listHorario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String dia = request.getParameter("dia");
        String entrada = request.getParameter("hora_entrada");
        String salida = request.getParameter("hora_salida");
        int idEmpleado = Integer.parseInt(request.getParameter("id_empleado"));

        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            HorarioTrabajo h = new HorarioTrabajo(id, dia, entrada, salida, idEmpleado, true);
            dao.update(h);
        } else {
            HorarioTrabajo h = new HorarioTrabajo(dia, entrada, salida, idEmpleado, true);
            dao.save(h);
        }

        response.sendRedirect("horario");
    }
}