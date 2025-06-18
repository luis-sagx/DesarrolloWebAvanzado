<%-- 
    Document   : listHorario
    Created on : 27 may. 2025, 21:04:08
    Author     : Luis Sagnay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<<<<<<< HEAD
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
=======
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
    </head>
    <body>
        <h2>Lista de Horarios</h2>
        <a href="horario?option=new">Agregar nuevo</a>
        <table>
            <tr>
                <th>ID</th><th>Día</th><th>Entrada</th><th>Salida</th><th>ID Empleado</th><th>Acciones</th>
            </tr>
            <c:forEach var="h" items="${horarios}">
                <tr>
                    <td>${h.idHorario}</td>
                    <td>${h.dia}</td>
                    <td>${h.horaEntrada}</td>
                    <td>${h.horaSalida}</td>
                    <td>${mapaEmpleados[h.idEmpleado]}</td>
                    <td>
                        <a href="horario?option=update&id=${h.idHorario}">Editar</a>
                        <a href="horario?option=delete&id=${h.idHorario}" onclick="return confirm('¿Eliminar?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>

</html>
