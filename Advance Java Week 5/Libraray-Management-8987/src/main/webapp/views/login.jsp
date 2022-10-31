<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,200;0,400;1,300&display=swap"
	rel="stylesheet">
<!-- <link href="css/mystyle.css" rel="stylesheet" type="text/css"/> -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"
	integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<!-- <script src="js/myjs.js" type="text/javascript"></script> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

<title>Login Page</title>
</head>
<body>

	<div class="container">
		<div class="row mt-5 align-items-center">
			<div class="col-md-8 mx-auto offset-md-4 ">
				<div class="card">
					<c:if test="${not empty message}">
						<div class="text-center mb-2" style="color: red">
							<div class="alert ${message.getCssClass()}" role="alert">${message.getMessageDetails()}</div>
						</div>
					</c:if>
					<%
					session.removeAttribute("message");
					%>
					<div class="card-header">
						<h3>Login</h3>
					</div>
					<div class="card-body">
						<form action="/validate" method="post">
							<div class="form-group">
								<div class="input-group mb-3 mx-0 mx-md-5">
									<label for="username" class="col-3">Username :</label> <span
										style="color: red">*</span>
									<div class="col-8 col-md-7">
										<input name="username" type="text" class="form-control"
											id="name" minlength="5" maxlength="50" required>
									</div>
									<span class="formerror"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group mb-3 mx-0 mx-md-5">
									<label for="password" class="col-3">Password :</label> <span
										style="color: red">*</span>
									<div class="col-8 col-md-7">
										<input name="password" type="password" class="form-control"
											id="password" minlength="5" maxlength="50" required>
									</div>
								</div>
							</div>
							<div class="card-footer text-center">
								<button type="submit" class="btn btn-outline-primary">Login
									>></button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>


</body>
</html>