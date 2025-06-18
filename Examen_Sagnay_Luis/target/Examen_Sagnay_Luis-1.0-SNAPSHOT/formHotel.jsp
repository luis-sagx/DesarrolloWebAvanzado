<%-- 
    Document   : formHotel
    Created on : 28 may. 2025, 09:34:24
    Author     : Luis Sagnay
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Hotel</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #dfe9f3, #ffffff);
            padding: 40px;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            padding: 25px 30px;
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
            color: #34495e;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        input[type="time"] {
            width: 100%;
            padding: 10px 12px;
            margin-bottom: 16px;
            border: 1px solid #bdc3c7;
            border-radius: 6px;
            font-size: 15px;
            transition: border-color 0.3s;
        }

        input:focus {
            outline: none;
            border-color: #5a94e0;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #3498db;
            color: #fff;
            border: none;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s;
        }

        button:hover {
            background-color: #2980b9;
            transform: translateY(-1px);
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #3498db;
            text-decoration: none;
            font-weight: 500;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>${hotel != null ? "Editar Hotel" : "Registrar Hotel"}</h2>

    <form action="hotel" method="post">
        <c:if test="${hotel != null}">
            <input type="hidden" name="id" value="${hotel.id}">
        </c:if>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${hotel.nombre}" required>

        <label for="categoria">Categoría:</label>
        <input type="text" id="categoria" name="categoria" value="${hotel.categoria}" required>

        <label for="totalHabitaciones">Total de Habitaciones:</label>
        <input type="number" id="totalHabitaciones" name="totalHabitaciones" value="${hotel.totalHabitaciones}" required>

        <label for="avaluo">Avaluo:</label>
        <input type="number" id="avaluo" name="avaluo" value="${hotel.avaluo}" required>

        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" value="${hotel.fecha}" required>

        <label for="hora">Hora:</label>
        <input type="time" id="hora" name="hora" value="${hotel.hora}" required>

        <button type="submit">Guardar</button>
        <a href="hotel">Cancelar</a>
    </form>
</body>
</html>
