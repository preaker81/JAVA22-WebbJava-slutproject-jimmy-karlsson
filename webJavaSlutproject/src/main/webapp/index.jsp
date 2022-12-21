<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css">
<title>OpenWeather</title>
</head>
<body>
	<nav>
		<ul class="nav-list">
			<li class="nav-item"><a href="./index.jsp">Home</a></li>
		</ul>
	</nav>

	<main class="main-container">
		<section class="form-container">
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
		</section>
	</main>

	<footer>
		<div>&copy; Jimmy Karlsson | preaker18@gmail.com</div>
	</footer>

	<div class="cookie-consent-modal">
		<div class="content">
			<h1>Allow cookies</h1>
			<p>Some random text</p>
			<div class="concent-btns">
				<button class="btn accept">Accept</button>
				<button class="btn cancel">Cancel</button>
			</div>
		</div>
	</div>

	<script src="./js/main.js"></script>
</body>
</html>