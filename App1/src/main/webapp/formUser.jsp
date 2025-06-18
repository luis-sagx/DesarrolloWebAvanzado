<%-- 
    Document   : formUser
    Created on : 9 may. 2025, 10:20:38
    Author     : Luis Sagnay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Formulario Usuario</title>
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
</head>
<body>
    <h2>${user != null ? "Editar" : "Nuevo"} Usuario</h2>
    <form action="user" method="post">
        <input type="hidden" name="id" value="${user.id}">
        
        <label for="name">Nombre:</label>
        <input type="text" name="name" id="name" value="${user.name}">
        
        <label for="lastName">Apellido:</label>
        <input type="text" name="lastName" id="lastName" value="${user.lastName}">
        
        <label for="age">Edad:</label>
        <input type="number" name="age" id="age" value="${user.age}">
        
        <input type="submit" value="Guardar">
    </form>
    <a href="user">Volver</a>
</body>
</html>

