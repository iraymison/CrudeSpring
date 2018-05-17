<%-- 
    Document   : adcUsuario
    Created on : 14/05/2018, 20:50:44
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
        <h1>Formulário de Adição de Usuários</h1>
        <form action="<c:url value='/adcUsuario'/>" method="post">
            
                <td>Login </td>
                    <td>
                        <input
                            type="txt"
                            name="login"/>
                    </td>
                </tr>
                <td>Senha </td>
                    <td>
                        <input
                            type="password"
                            name="senha"/>
                    </td>
                </tr>
                <input type="submit" value="Adicionar">
            
        </form>
    </body>
</html>
