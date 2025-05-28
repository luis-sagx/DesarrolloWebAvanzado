<%-- 
    Document   : formHorario
    Created on : 27 may. 2025, 21:03:37
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
        <h2>${horario != null ? "Editar" : "Nuevo"} Horario de Trabajo</h2>
        <form action="horario" method="post">
            <input type="hidden" name="id" value="${horario.idHorario}">
            <label>Día:</label>
            <input type="text" name="dia" value="${horario.dia}"><br>
            <label>Hora Entrada:</label>
            <input type="time" name="hora_entrada" value="${horario.horaEntrada}"><br>
            <label>Hora Salida:</label>
            <input type="time" name="hora_salida" value="${horario.horaSalida}"><br>
            <label>Empleado:</label>
            <label>Empleado:</label>
            <select name="id_empleado">
                <c:forEach var="emp" items="${empleados}">
                    <option value="${emp.id_empleado}"
                        <c:if test="${emp.id_empleado == horario.idEmpleado}">selected</c:if>>
                        ${emp.cargo}
                    </option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Guardar">
        </form>
        <a href="horario">Volver</a>
    </body>

</html>
