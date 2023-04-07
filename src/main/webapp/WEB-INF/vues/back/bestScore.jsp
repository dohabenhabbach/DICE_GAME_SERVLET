<%@page import="com.example.solution.bo.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
	rel="stylesheet">

<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>App Game</title>
</head>
<body>



	<h1 align="center">Meilleurs scores</h1>
	<%
	//On récupère les utilisateurs de la requete
		List<User> users = (List<User>) request.getAttribute("users");
		out.print("<table class=\"table\" style=\"background-color: #f2f2f2; padding: 10px;\">");
		out.print("<tr><th>Nom</th><th>Score</th></tr>");
		//On affiche le best score
		for (User it : users) {
			out.print("<tr><td>" + it.getNom() + "</td><td>" + it.getBestScore() + "</td></tr>");

		}
		out.print("</table>");
	%>





</body>
</html>