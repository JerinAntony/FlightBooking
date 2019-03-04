<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Availability</title>
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
</style>
<body>
	<div align="center">
		<form method="post">
			<h3 style="color: white">Airlines Available</h3>
			<table
				style="font-family: times new roman; border-collapse: collapse; color: white">
				<thead>
					<tr>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Flight
							Name</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Flight
							No</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Class
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Adult
							Seats</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Price</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Child
							Seats</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Price
						</th>
						<th
							style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Status</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="airlines" items="${AIRLINES}">
						<tr>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.flightName}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.flightNo}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.flightClass}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.adultSeats}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.adultPrice}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.childSeats}</td>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.childPrice}</td>
							<%-- <td><input type="checkbox" name="delete"
								value="${product.id}"></td> --%>
							<td
								style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${airlines.status}</td>
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
						<button type="submit">Logout</button>
					</form>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>