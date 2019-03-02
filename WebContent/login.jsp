<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<style>
.display {
	position: absolute;
	top: 37%;
	left: 20%;
}

body {
	text-align: center;
	padding-top: 230px;
}

form {
	display: inline-block;
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
</style>
<body bgcolor="white">


	<form method="post" action="LoginServlet">
		<div class="display">
			<img src="airplane.png" alt="hh" width="300px" height="150px">

		</div>
		<table width="300px" height="200px">

			<tr align="center">

				<td style="color: black" colspan="2" style="padding-top:60px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Flight
					Booking</td>
				<td></td>
			</tr>


			<tr>
				<td style="color: black">Email :</td>
				<td><input type="email" name="email" required></td>

			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>

				<td style="color: black">Password :</td>
				<td><input type="password" name="password" pattern=".{6,}"
					title="Six or more characters"></td>
			</tr>
			<tr>

				<td></td>
				<td><a href="passanger_registration.jsp">New User</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="forget_password.jsp">Forget Password</a></td>
			</tr>
			<tr>
				<td colspan="2" style="color: red">${ALERT}</td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td><button type="submit" style="width: 100px"
						class="button button1">Login</button> <br></td>
			</tr>


		</table>

	</form>
</body>
</html>