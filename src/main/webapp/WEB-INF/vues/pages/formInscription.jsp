<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

</head>
<body>
	<div id="login-form-wrap">
		<h2>Inscription</h2>

		<form id="login-form"  method="post"
			action="${pageContext.request.contextPath}/UserManagementServlet">
			<input type="hidden"  name="action" value="create">
			<p>
				<input type="text" id="username" name="nom" placeholder="nom" required><i class="validation"><span></span><span></span></i>
			</p>
			<p>
				<input type="email" id="email" name="login" placeholder="login" required><i class="validation"><span></span><span></span></i>
			</p>
			<p>
				<input type="password" id="password" name="password" placeholder="password" required><i class="validation"><span></span><span></span></i>
			</p>
			<p>
				<input type="password" id="confirm-password" name="password" placeholder="confirm-password" required><i class="validation"><span></span><span></span></i>
			</p>
			<p>
				<input type="submit" id="create-account" value="Create Account">
			</p>
		</form>
		<div id="create-account-wrap">
			<p>Merci pour votre inscription ! <p>
		</div>
	</div>


		</form>
	</div>
</body>

</html>