<%@ page import="com.example.solution.bo.GameState" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 20/03/2023
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Mon meilleur Score </h4>

<%
    GameState gameState = (GameState) request.getSession().getAttribute("gameState");

    if (gameState != null && gameState.getUser() != null) {
        out.print(Math.max(gameState.getUser().getBestScore(), gameState.getUser().getScore()));
    }
%>


<%
    out.print(gameState);
%>

</body>
</html>
