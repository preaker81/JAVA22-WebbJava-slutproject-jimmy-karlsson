<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css">
<title>the weather</title>
</head>
<body>
	<nav>
		<ul class="nav-list">
			<li class="nav-item"><a href="./index.jsp">Home</a></li>
		</ul>
	</nav>

	<main class="main-container">

		<div class="form-container">
			<form action="OWservlet" method="get">
				<label for="cityName">City</label> <input type="text" id="cityName"
					name="city" placeholder="Choose a city.." required> <label
					for="countryName">Country</label> <input type="text"
					id="countryName" name="country" placeholder="In what country?" required>

				<label for="temperature">Temperature</label> <select
					id="temperature" name="temp">
					<option value="c">Celcius</option>
					<option value="f">Farenheight</option>
					<option value="k">Kelvin</option>
				</select> <input type="submit" value="Submit">

			</form>
		</div>


		<section class="results-container">
			<h3>Results</h3>
			<br>
			<%
			weatherBean wBean = (weatherBean) request.getAttribute("wBean");
			out.print("<p><b>Cloud cover right now: </b></p>");
			out.print("<p>" + wBean.getCloudsStr() + "</p>");

			out.print("<p><b>Temperature right now: </b></p>");
			out.print("<p>" + wBean.tempCalculator() + " \u00B0" + wBean.getTempChoice().toUpperCase() + "</p>");
			
			out.print("<pre>Last update: " + wBean.getLastupdateStr() + "</pre>");

			%>
		</section>

		<section class="searches-container">
			<h3>Recent searches</h3>
			<%
			for (int i = 1; i < wBean.cookieCutter().size(); i++) {
				
				String[] parts = wBean.cookieCutter().get(i).split("-",2);
				String city = parts[0];
				String country = parts[1];
				out.print("<a href=\"http://localhost:8080/webJavaSlutproject/OWservlet?city=" + city + "&country=" + country + "&temp=" + wBean.getTempChoice() + "\"><p>" + city + " " + country + "</p></a>");
			}
			%>
		</section>

	</main>

	<footer>
		<div>&copy; Jimmy Karlsson | preaker18@gmail.com</div>
	</footer>
</body>
</html>