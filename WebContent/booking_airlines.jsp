<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Flights</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
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

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}
</style>
<body>
	<div align="center">

		<form method="post" action="AddBookingFlightServlet">

			<h2 style="color: white;">Book Flights</h2>
			<table>
				<tr>
					<td style="color: white;">Airlines :</td>
					<td><select name="airlines" id="airLines">
							<c:forEach var="airlines" items="${AIRLINES}">
								<option value="${airlines.id}">${airlines.airlinesName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td style="color: white;">Class</td>
					<td style="color: white;"><input type="radio"
						name="flightclass" value="Economy">Economy <input
						type="radio" name="flightclass" value="Business">Business<input
						type="radio" name="flightclass" value="First">First</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Adult seats :<br />(age 12+)
					</td>
					<td><select name="adultseats" id="adultseats">
							<option value="">Select Seats</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Children seats :<br />(age 2-11)
					</td>
					<td><select name="childseats" id="childseats">
							<option value="">Select Seats</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Infant:<br />(Ages 0-1,on lap)
					</td>
					<td><select name="infant">
							<option value="">Select</option>
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td style="color: white;">Co-Passengers names :</td>
					<td><input type="text" name="names"></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><a href="home.jsp" style="color: white">Back</a></td>
					<td>
						<button style="width: 150px;" class="button button1" type="submit">Confirm
							Book</button>
					</td>
				</tr>
			</table>

		</form>




	</div>
</body>
</html>