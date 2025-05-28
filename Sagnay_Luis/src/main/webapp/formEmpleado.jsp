<%-- 
    Document   : formEmpleado
    Created on : 26 may. 2025, 10:26:01
    Author     : Luis Sagnay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Empleado</title>
    </head>
    <body>
        <h2>${empleado != null ? "Editar" : "Nuevo"} Empleado</h2>
        <form action="empleado" method="post">
            <input type="hidden" name="id_empleado" value="${empleado.id_empleado}">

            <label for="cargo">Cargo:</label>
            <input type="text" name="cargo" id="cargo" value="${empleado.cargo}">

            <label for="salario">Salario:</label>
            <input type="number" step="0.01" name="salario" id="salario" value="${empleado.salario}">

            <input type="submit" value="Guardar">
        </form>
        <a href="empleado">Volver</a>
    </body>

</html>
