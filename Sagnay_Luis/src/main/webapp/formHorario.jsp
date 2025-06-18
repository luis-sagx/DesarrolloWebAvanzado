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
<<<<<<< HEAD
        <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            padding: 40px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        form input[type="text"],
        form input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #5a94e0;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        form input[type="submit"]:hover {
            color: #5a94e0;
            background-color: transparent;
            border: 2px solid #5a94e0
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        label {
            display: block;
            margin-bottom: 6px;
            color: #555;
        }
    </style>
=======
>>>>>>> 4cdb927144d782137baa43779d1f107fd8020d04
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
