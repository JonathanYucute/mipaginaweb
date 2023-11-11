<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuarios</title>
</head>
<body>

    <h1>Lista de Usuarios</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Email</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.id}</td>
                ${usuario.nombre}
                <td>${usuario.apellido}</td>
                <td>${usuario.email}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>Agregar Usuario</h2>
    <form action="UsuarioServlet" method="post">
        Nombre: <input type="text" name="nombre" required><br>
        Apellido: <input type="text" name="apellido" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Agregar">
    </form>

</body>
</html>

