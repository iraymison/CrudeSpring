<%-- 
    Document   : listagem-usuarios
    Created on : 15/05/2018, 13:15:42
    Author     : Raymison
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
        <table>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Ações</th>
            </tr>
            <c:forEach items="${listaUsuarios}" var="usuario">
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.login}</td>
                <td>
                    <a href="removeUsuario?id=${usuario.id}"
                       onclick="return confirm('Deseja realmente excluir?')">Remover</a>
                    <a href="exibeUsuario?id=${usuario.id}"> Alterar</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
