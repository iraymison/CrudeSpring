<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <a href="${pageContext.request.contextPath}/welcome"></a>
        </br>
        <a href="${pageContext.request.contextPath}/formAdcUsuario">Adiciona Usuários</a>
        </br>
        <a href="${pageContext.request.contextPath}/listaUsuarios">Listar Usuários</a>
    </body>
</html>
