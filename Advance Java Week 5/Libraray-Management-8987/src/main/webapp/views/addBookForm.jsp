<%@page import="org.springboot.mvc.helper.DisplayMessageToJSP"%>
<%@page import="org.springboot.mvc.model.Librarian"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<title>Add book page</title>
</head>
<body>
	<!-- header -->
	<header class="bg-primay bordered">
		<%@ include file="navbar.jsp"%>
	</header>

	<div class="container" style="min-height: 100vh">
		<form action="/add" method="post">
			<div class="text-center my-4 mb-5">
				<h3>Add Book Details</h3>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="bookCode">Book Code</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="bookCode"
							name="bookCode" value="${existingBook.getBookCode()}">
						<c:if test="${not empty message}">
							<div class="text-center mb-2" style="color: red">
								<h6>${message}</h6>
							</div>
						</c:if>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="bookName">Book Name</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="bookName"
							name="bookName" value="${existingBook.getBookName()}">
					</div>
				</div>
			</div>


			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="authorName">Author</label>
					</div>
					<div class="col-5">
						<select name="authorName" id="authorName" class="form-control">
							<c:forEach var="author" items="${authors}">
								<option value=${author.get("authorName")}>${author.get("authorName")}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="createdDate">Date</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="createdDate"
							name="createdDate" readonly>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='/bookList'"
				class="btn btn-danger">Cancel</button>
		</form>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		$.get('/checkUserSession', function(){
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			console.log("done")
		})
	})
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth() + 1;
		var date = today.getDate();
		var currentDate = date + "/" + month + "/" + year;
		document.getElementById("createdDate").value = currentDate;
		
		function preback(){window.history.forward();}
		setTimeout("preback()",0);
		window.onunload= function(){null};
	</script>
</body>
</html>