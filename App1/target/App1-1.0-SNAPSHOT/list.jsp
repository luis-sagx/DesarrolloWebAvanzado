
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
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
        <h2>Lista de Usuarios</h2>
        <a href="user?option=new">Agregar nuevo</a>
        <table>
            <tr>
                <th>ID</th><th>Nombre</th><th>Apellido</th><th>Edad</th><th>Acciones</th>
            </tr>
            
            <c:forEach var="user" items="${users}">
                <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>
                    <a href="user?option=update&id=${user.id}">Editar</a>
                    <a href="user?option=delete&id=${user.id}" onclick="return confirm('¿Eliminar?')">Eliminar</a>
                </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>