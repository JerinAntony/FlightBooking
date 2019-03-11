<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Summary</title>
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
</style>
<body>
	<div align="left" style="color: white">Welcome ${NAME}</div>
	<div align="center">
		<form method="post" action="TicketCancellationServlet">
			<h3 style="color: white">Booking Summary</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse; color: white">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Airlines
							Name</th>

						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Flight
							No</th>


						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Adult
							Seats</th>

						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Child
							Seats</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Infant
						</th>

						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Co-Passangers
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Price
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Booking
							date</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Status
						</th>

						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Passenger
						</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="booking" items="${BOOKING}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.airlinesId.flightName.airlinesName}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.airlinesId.flightNo}</td>

							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.adultSeats}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.childSeats}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.infant}</td>

							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.coPassangersname}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.price}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.bookingDate}</td>


							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">
								<c:if test="${booking.cancelStatus=='0'}">
									Confirmed
									
								</c:if> <c:if test="${booking.cancelStatus=='1'}">
									Cancelled
									
								</c:if>

							</td>

							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${booking.passenger_id.name}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div align="center">
		<table>
			<tr>
				<td><a href="home.jsp" style="color: white">Back</a></td>
				<td width="20px"></td>
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