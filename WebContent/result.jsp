<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.dto.FlightStructure"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<style type="text/css">
.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

<
style type ="text /css">.result {
	width: 100%;
	border-collapse: collapse;
	background-color: #f2f2f2;
}

.result td {
	text-align: center;
	height: 25px;
	border: 1px solid black;
}

th {
	text-align: center;
	height: 50px;
	border: 1px solid black;
}

input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #4169E1;
}
</style>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>

	<c:if test="${searchResult.size() != 0}">
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="result.jsp">Search for Flights</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<%
							if (session.getAttribute("username") == null && (session.getAttribute("authorized") == "false")) {
									response.sendRedirect("index.jsp");
								}
						%>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</nav>
		</header>
		<table class="w3-table w3-striped">
			<tr>
				<th>FLIGHT NUMBER</th>
				<th>DEPARTURE LOCATION</th>
				<th>ARRIVAL LOCATION</th>
				<th>DATE OF FLIGHT</th>
				<th>FLIGHT TIME</th>
				<th>FLIGHT DURATION</th>
				<th>FARE</th>
				<th>SEAT AVAILABILITY</th>
				<th>CLASS</th>
			</tr>
			<c:forEach items="${searchResult}" var="flight">
				<tr>
					<td align="center" style="padding-right: 10px">${flight.getFlightNumber()}</td>
					<td align="center" style="padding-right: 10px">${flight.getDepartLocation()}</td>
					<td align="center" style="padding-right: 10px">${flight.getArrivalLocation()}</td>
					<td align="center" style="padding-right: 10px">${flight.getFlightDate()}</td>
					<td align="center" style="padding-right: 10px">${flight.getFlightTime()}</td>
					<td align="center" style="padding-right: 10px">${flight.getFlightDuration()}</td>
					<td align="center" style="padding-right: 10px">${flight.getFare()}</td>
					<td align="center" style="padding-right: 10px">${flight.getSeatAvailablility()}</td>
					<td align="center" style="padding-right: 10px">${flight.getFlightClass()}</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<c:if test="${searchResult.size() == 0}">
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="homepage.jsp">Flights Not Found</a>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<%
							if (session.getAttribute("username") == null && (session.getAttribute("authorized") == "false")) {
									response.sendRedirect("index.jsp");
								}
						%>
						<li><a href="logout.jsp">Logout</a></li>
					</ul>
				</div>
			</nav>
		</header>
	</c:if>
	<br>
</body>
</html>