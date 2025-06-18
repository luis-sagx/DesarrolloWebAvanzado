/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package espe.edu.app.controller;

import espe.edu.app.dao.UserDAO;
import espe.edu.app.model.User;
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
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private final UserDAO userDao = new UserDAO();
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
                response.sendRedirect("User");
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
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        User user = new User(name, lastName, age);
        
        if(id == null){
            userDao.save(user);
        } else{
            userDao.update(user);
        }
    }

}
