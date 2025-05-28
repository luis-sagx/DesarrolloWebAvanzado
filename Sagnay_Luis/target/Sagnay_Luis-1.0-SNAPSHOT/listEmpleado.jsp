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
