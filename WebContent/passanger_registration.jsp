<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.display {
	position: absolute;
	top: 30%;
	left: 15%;
}

body {
	background: url("background-banner.jpg");
	text-align: center;
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

tr {
	padding: 10px;
}

input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=number] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=date] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}
</style>
<body style="color: white; font-family: Times New Roman;">

	<div class="display">
		<img src="registerpng.png" alt="hh" width="200px" height="200px">

	</div>
	<form method="post" action="AddPassangersServlet">
		<table>
			<tbody>
				<tr align="center">
					<td style="color: white" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<h4>Register</h4>
					</td>
					<td></td>
				</tr>
				<tr align="left">
					<td></td>
					<td></td>
				</tr>
				<tr align="left">
					<td style="color: white">Name :</td>
					<td><input type="text" name="name" required></td>

				</tr>

				<tr align="left">
					<td style="color: white">Email Id :</td>
					<td><input type="email" name="email" required></td>
				</tr>

				<tr align="left">
					<td style="color: white">Phone no :</td>
					<td><input type="number"  maxlength="10"
						pattern="([0-9]{10})|(\([0-9]{3}\)\s+[0-9]{3}\-[0-9]{4})"
						name="phone" required></td>
				</tr>

				<tr align="left">
					<td style="color: white">Father DOB :</td>
					<td><input type="date" name="fatherdob" required></td>
				</tr>

				<tr align="left">
					<td style="color: white">Username :</td>
					<td><input type="text" name="username" required></td>
				</tr>

				<tr align="left">
					<td style="color: white">Password :</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td style="color: yellow" colspan="2">${DISPLAY}</td>
					<td></td>
				</tr>
				<tr>

					<td colspan="2"><a href="login.jsp" style="color: white">Back</a>
						<button type="submit" style="width: 200px" class="button button1">Sign
							Up</button></td>
					<td></td>
				</tr>

			</tbody>
		</table>
	</form>
</body>
</html>