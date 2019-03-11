<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change password</title>
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

input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

</style>
<body>
<div align="left" style="color: white">Welcome ${NAME}</div>
	<div align="center">

		<form id="changepassword" method="post" action="ChangePasswordServlet">

			<h2 style="color: white;">Change Password</h2>
			<table>
				<tr>
					<td style="color: white;">Old Password :</td>
					<td><input type="password" name="oldpassword" required></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">New Password :</td>
					<td><input type="password" name="newpassword" required></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Confirm Password :</td>
					<td><input type="password" name="confirmpassword" required></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr align="center">
					<td style="color: yellow;" colspan="2">${DISPLAY}</td>
					<td></td>
				</tr>

				<tr>
					<td><a href="home.jsp" style="color: white">Back</a></td>
					<td align="center">
						<button style="width: 200px;" class="button button1" type="submit">Change
							Password</button>
					</td>
				</tr>
			</table>

		</form>




	</div>
</body>
</html>