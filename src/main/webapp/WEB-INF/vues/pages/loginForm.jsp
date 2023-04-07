<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.example.solution.bo.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.example.solution.bo.GameState"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>App Game</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/style/registration.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/style/registration.css"
	rel="stylesheet">
</head>

<body>

	<div class="container" id="login-form-wrap">


		<form id="login-form" class="form-signin" method="POST"
			action="${pageContext.request.contextPath}/LoginServlet">
			<h2>Login</h2>
			<%--@declare id="inputemail"--%>

				<p>
					<input type="email" id="email" name="login" placeholder="login" required><i class="validation"><span></span><span></span></i>
				</p>
				<p>
					<input type="password" id="password" name="password" placeholder="password" required><i class="validation"><span></span><span></span></i>
				</p>
				<p>
					<input type="submit" id="login" value="Login">
				</p>
		</form>
		<div id="create-account-wrap">
			<p>Not a member? <a href="${pageContext.request.contextPath}/UserManagementServlet?create">Create Account</a><p>
		</div>
	</div>


	</form>

		<div>


			<!-- 	//afficher les message avec JAVA  -->

			<!--  		List<Message> messages = (List<Message>) request.getAttribute("messages"); -->

			<!--  		if (messages != null) { -->
			<!-- 			for (Message it : messages) { -->
			<!-- 			out.print(it); -->
			<!--  			} -->
			<!-- 		} -->



			<!-- Ou mieux on affiche les message avec JSTL -->
			<ul>

				<c:forEach items="${requestScope.messages}" var="msg">

					
					<c:choose>
					  <c:when test="${msg.type == Message.WARN}">
					   <li style="color: red">${msg.text}</li>
					  </c:when>
					  <c:when test="${msg.type == Message.INFO}">
					   <li style="color: green">${msg.text}</li>
					  </c:when>
					   <c:when test="${msg.type == Message.ERROR}">
					   <li style="color: red">${msg.text}</li>
					  </c:when>
						<c:when test="${msg.type == Message.SUCCESS}">
							<li style="color: yellow">${msg.text}</li>
						</c:when>
					  <c:otherwise>
					  <li >${msg.text}</li>
					  </c:otherwise>
					</c:choose>

				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- /container -->
</body>
</html>
