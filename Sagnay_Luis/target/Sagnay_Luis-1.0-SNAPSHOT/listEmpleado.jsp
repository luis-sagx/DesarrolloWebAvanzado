<%-- 
    Document   : listEmpleado
    Created on : 27 may. 2025, 20:54:59
    Author     : Luis Sagnay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                padding: 20px;
            }

            h2 {
                color: #5a94e0;
                text-align: center;
                margin-bottom: 20px;
                font-weight: bold;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                background-color: #ffffff;
            }

            th, td {
                padding: 12px 15px;
                text-align: center;
                border-bottom: 1px solid #e0e0e0;
                color: #333333;
            }

            th {
                background-color: #5a94e0;
                font-weight: bold;
                color: #ffffff;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #f1f9ff;
                transition: background-color 0.3s;
            }

            a {
                margin: 2px 5px;
                padding: 6px 12px;
                border-radius: 4px;
                font-size: 14px;
                color: #ffffff;
                background-color: #5a94e0;
                border: 1px solid #5a94e0;
                transition: background-color 0.3s, color 0.3s;
                text-decoration: none;
                display: inline-block;
            }

            a:hover {
                background-color: transparent;
                color: #5a94e0;
            }
        </style>
    </head>
        <body>
        <h2>Lista de Empleados</h2>
        <a href="empleado?option=new">Agregar nuevo</a>
        <table border="1">
            <tr>
                <th>ID</th><th>Cargo</th><th>Salario</th><th>Acciones</th>
            </tr>
            <c:forEach var="e" items="${empleados}">
                <tr>
                    <td>${e.id_empleado}</td>
                    <td>${e.cargo}</td>
                    <td>${e.salario}</td>
                    <td>
                        <a href="empleado?option=update&id=${e.id_empleado}">Editar</a>
                        <a href="empleado?option=delete&id=${e.id_empleado}" onclick="return confirm('¿Eliminar?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
