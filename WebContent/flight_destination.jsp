<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flight Destination</title>
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
	<div align="left" style="color: white">Welcome ${NAME}</div>


	<div align="center" style="width: 900px">

		<form method="post" action="AddFlightDestinationServlet">
			<table>
				<tr>
					<td><table>
							<tr>
								<td></td>
								<td><h2 style="color: white;">Add Destination</h2></td>
							</tr>
							<tr>
								<td style="color: white;">Flight Destination :</td>
								<td><input type="text" name="flightdestination"></td>
							</tr>



							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><a href="home.jsp" style="color: white">Back</a></td>
								<td align="center"><button style="width: 100px;"
										type="submit" class="button button1">Save</button></td>
							</tr>
						</table></td>
					<td><table align="center"
							style="font-family: times new roman; border-collapse: collapse; color: white">
							<thead>
								<tr>
									<th
										style="border: 1px solid #dddddd; text-align: left; padding: 8px;">Flight
										Destinations</th>


								</tr>
							</thead>
							<tbody>
								<c:forEach var="flightdestination" items="${FLIFHTDEST}">
									<tr>
										<td
											style="border: 1px solid #dddddd; text-align: left; padding: 8px;">${flightdestination.place}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table></td>
				</tr>
			</table>



		</form>

	</div>

</body>
</html>