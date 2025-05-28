package espe.edu.app1.controller;

import espe.edu.app1.dao.UserDao;
import espe.edu.app1.model.User;
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
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {

    private final UserDao userDao = new UserDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");
        
        if(option == null){
            option = "findAll";
        }
        
        switch (option){
            case "new":
                request.getRequestDispatcher("/formUser.jsp").forward(request, response);
                break;
            case "update":
                Long id = Long.parseLong(request.getParameter("id"));
                User user = userDao.findById(id);
                request.setAttribute("user",user);
                request.getRequestDispatcher("/formUser.jsp").forward(request,response);
                break;
            case "delete":
                Long idDelete = Long.parseLong(request.getParameter("id"));
                userDao.delete(idDelete);
                response.sendRedirect("user");
                break;
            default :
                List<User> users = userDao.findAll();
                request.setAttribute("users", users);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        if (idStr != null && !idStr.isEmpty()) {
            Long id = Long.parseLong(idStr);
            User user = new User(id, name, lastName, age);
            userDao.update(user);
        } else {
            User user = new User(name, lastName, age);
            userDao.save(user);
        }

        response.sendRedirect("user");
    }


}

