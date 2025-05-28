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
