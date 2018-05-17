<%-- 
    Document   : exibe-usuario
    Created on : 15/05/2018, 14:02:11
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
        <h1>Alterar usuario - ${usuario.id}</h1>
        <form action="<c:url value='/alteraUsuario'/>" method="post">
            <input type="hidden" name="id" value="${usuario.id}"/>
            <td>Login </td>
                    <td>
                        ${usuario.login}
                        <input
                            type="txt"
                            name="login"/>
                    </td>
                </tr>
                <td>Senha </td>
                    <td>
                        ${usuario.senha}
                        <input
                            type="password"
                            name="senha"/>
                    </td>
                </tr>
                <input type="submit" value="Alterar">
        </form>
    </body>
</html>
