<%-- 
    Document   : list
    Created on : 7 may. 2025, 10:45:13
    Author     : Luis Sagnay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>List of Users</h2>
        <a href="users?action=new">Add new</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last name</th>
                <th>Age</th>
            </tr>
            <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>
                    <a href="users?action=edit&id=${users.id}">Edit</a>
                    <a href="users?action=delete&id=${users.id}">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
