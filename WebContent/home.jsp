<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
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

input[type=number] {
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
		<table>
			<tr>
				<td>
					<div align="center" style="width: 900px">

						<form method="post" action="AddAirlinesFlightServlet">

							<h2 style="color: white;">Add Flight Details</h2>
							<table>
								<tr>
									<td style="color: white;">Airlines Name :</td>
									<td><select name="airlines">
											<c:forEach var="airlines" items="${AIRLINE}">
												<option value="${airlines.id}">${airlines.airlinesName}</option>
											</c:forEach>
									</select></td>
									<td width="6px"></td>
									<td style="color: white;">Flight No :</td>
									<td><input type="text" name="flightno"></td>
								</tr>

								<tr>
									<td style="color: white;">Class</td>
									<td style="color: white;"><input type="radio"
										name="flightclass" value="Economy" checked>Economy <input
										type="radio" name="flightclass" value="Busniness">Busniness<input
										type="radio" name="flightclass" value="First">First</td>
									<td></td>
									<td style="color: white;">Adult seats :<br />(age 12+)
									</td>
									<td><input type="number" name="adultseats"></td>
								</tr>

								<tr>
									<td></td>
								</tr>
								<tr>
									<td style="color: white;">Price (1 seat) :<br />(Adult)
									</td>
									<td><input type="number" name="adultprice"></td>
									<td></td>
									<td style="color: white;">Children seats :<br />(age
										2-11)
									</td>
									<td><input type="number" name="childseats"></td>
								</tr>
								<tr>
									<td></td>
								</tr>
								<tr>
									<td style="color: white;">Price (1 seat) :<br />(Children)
									</td>
									<td><input type="number" name="childprice"></td>
									<td></td>
									<td style="color: white;">Status :</td>
									<td style="color: white;"><input type="radio"
										name="status" value="Y" checked>Available <input
										type="radio" name="status" value="N" checked>Not
										Available</td>
								</tr>
								<tr>
									<td></td>
								</tr>
								<tr>

								</tr>

								<tr>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<button style="width: 100px;" type="submit"
											class="button button1">Save</button>
									</td>
									<td></td>
								</tr>
							</table>

						</form>




					</div>
				</td>
			</tr>
		</table>
		<br /> <br />
		<table>
			<tr>
				<td><form method="post" action="AirlinesServlet">
						<button type="submit" name="addairlines" value="airlines" class="button button1">Add Airlines</button>
					</form></td>
				<td>
					<form method="post" action="CheckFlightAvailablityServlet">
						<button type="submit" class="button button1">Flights
							Available</button>
					</form>
				</td>
				<td>
					<form method="post" action="BookFlightServlet">
						<button type="submit" class="button button1">Book Flight</button>
					</form>
				</td>
				<td>
					<form method="post" action="BookingSummaryServlet">
						<button type="submit" class="button button1">Booking
							Summary</button>
					</form>
				</td>
				<td>
					<form method="post" action="AirlinesServlet">
						<button type="submit" name="calcellation" value="ticketcancel" class="button button1">Ticket
							Cancellation</button>
					</form>
				</td>
				
				<td>
					<form method="post" action="RedirecttoChangePasswordServlet">
						<button type="submit" class="button button1">Change
							Password</button>
					</form>
				</td>
				<td>
					<form method="post" action="LogoutServlet">
						<button type="submit" class="button button1">Logout</button>
					</form>
				</td>

			</tr>
		</table>
	</div>
</body>
</html>