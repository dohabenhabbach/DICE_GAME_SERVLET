<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.example.solution.bo.GameState"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Game App</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/style/game.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/style/game.css"
	rel="stylesheet">
</head>
<body>
<div align="center">

	<h1>Lancer des dés </h1>
	<tr >
		<td><img src="${pageContext.request.contextPath}/image/diceimage.png" height="180"></td>
	</tr >
	<h4>Utilisateur connecté: <c:out value="${sessionScope.gameState.user.nom}" /></h4>
	<p>Entrer le numéro du dé à lancer puis cliquer sur le bouton</p>
	<form action="${pageContext.request.contextPath}/back/GameServlet" method="POST">
	    <p>Numéro de dés : <input type="number" name="diceNumber"  required></p>
		<input type="submit" value="Lancer le dé" />
	</form>



</div>



	<footer>
		<hr>
		<a href="${pageContext.request.contextPath}/back/bestScore">Meilleure score</a>|
		<a href="${pageContext.request.contextPath}/back/ReinitGameServlet">Réinitialiser </a>|
		<a href="${pageContext.request.contextPath}/DeconnectServlet">Se deconnecter</a> |
		</hr>
	</footer>





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