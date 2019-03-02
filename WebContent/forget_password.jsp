<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget password</title>
</head>
<style>
body {
	background: url("background-banner.jpg");
	text-align: center;
	padding-top: 50px;
}

form {
	display: inline-block;
}

.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 8px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 12px;
	margin: 4px 2px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.button1:hover {
	background-color: #4CAF50;
	color: white;
}

input[type=number] {
	width: 100%;
	padding: 8px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 3px solid #ccc;
	-webkit-transition: 0.5s;
	transition: 0.5s;
	outline: none;
}

input[type=number]:focus {
	border: 3px solid #555;
}

input[type=email] {
	width: 100%;
	padding: 8px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 3px solid #ccc;
	-webkit-transition: 0.5s;
	transition: 0.5s;
	outline: none;
}

input[type=email]:focus {
	border: 3px solid #555;
}

input[type=date] {
	width: 100%;
	padding: 8px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 3px solid #ccc;
	-webkit-transition: 0.5s;
	transition: 0.5s;
	outline: none;
}

input[type=date]:focus {
	border: 3px solid #555;
}
</style>
<body>

	<div align="center">

		<form method="post" action="ForgetPasswordServlet">

			<h2 style="color: white;">Forget Password</h2>
			<table>
				<tr>
					<td style="color: white;">Phone no :</td>
					<td><input type="number" name="phoneno" required></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Email :</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Father DOB :</td>
					<td><input type="date" name="fatherdob" required></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr align="center">
					<td style="color: white;" colspan="2">${DISPLAY}</td>
					<td></td>
				</tr>

				<tr>
					<td><a href="login.jsp" style="color: yellow">Back</a></td>
					<td align="center">
						<button style="width: 150px;" class="button button1" type="submit">View
						</button>
					</td>
				</tr>
			</table>

		</form>




	</div>
</body>
</html>