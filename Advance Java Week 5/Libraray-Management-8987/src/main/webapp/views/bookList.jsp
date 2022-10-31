<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

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
<title>Listing of books</title>
</head>
<body>
	<!-- header -->
	<header class="bg-primay bordered">
		<%@ include file="navbar.jsp"%>
	</header>

	<div class="container mt-5" style="min-height: 100vh">
		<!-- <div class="card">
			<div class="card-body"> -->
		<div class="container">
			<div class="col-12">
				<table class="table h-100 table-bordered text-center"
					id="output-table">
					<thead>
						<tr>
							<th style="background-color: #D2DDE6" colspan="6" class="text-center mt-4">
								<h3>Books Listing</h3>
							</th>
						</tr>
						<tr>
							<th class="col-4 col-md-2 ">Book Code</th>
							<th class="col-4 col-md-2 ">Book Name</th>
							<th class="col-10 col-md-2 ">Author</th>
							<th class="col-4 col-md-2 ">Data Added</th>
							<th class="col-10 col-md-3">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td class="col-4 col-md-2 align-middle">${book.get("bookCode")}</td>
								<td class="col-4 col-md-2 align-middle">${book.get("bookName")}</td>
								<td class="col-10 col-md-2 align-middle">${book.get("authorName")}</td>
								<td class="col-4 col-md-2 align-middle">${book.get("createdDate")}</td>
								<td class="col-10 col-md-3 align-middle">
									<button class="btn btn-outline-secondary btn-sm" type="submit"
										onclick="location.href='/edit/${book.get("bookId")}'">Edit</button>&nbsp;&nbsp;
									<button class="btn btn-outline-danger btn-sm" type="submit"
										onclick="location.href='/delete/${book.get("bookId")}'">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	
	<script>
	
	$(document).ready(function(){
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		$.get('/checkUserSession', function(){
			response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			console.log("done")
		})
	})
	function preback(){window.history.forward();}
	setTimeout("preback()",0);
	window.onunload= function(){null};
	</script>
	
</body>
</html>