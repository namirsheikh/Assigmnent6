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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Edit book page</title>
</head>
<body>
<!-- header -->
	<header class="bg-primay bordered">
		<%@ include file="navbar.jsp"%>
	</header>

	<div class="container" style="min-height: 100vh">
		<form action="/update" method="post">
			<div class="text-center my-4 mb-5">
				<h3>Edit Book Details</h3>
			</div>
			
			<div class="form-group">
				<div class="row">
					<div class="col-5">
						<input type="hidden" class="form-control" id="bookId"
							name="bookId" value="${book.getBookId()}">
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="bookCode">Book Code</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="bookCode"
							name="bookCode" value="${book.getBookCode()}" readonly>
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
							name="bookName" value="${book.getBookName()}">
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
							name="createdDate"value="${book.getCreatedDate()}" readonly>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;
			<button type="button" onclick="location.href='/bookList'" class="btn btn-danger">Cancel</button>
		</form>
	</div>
	
	<script type="text/javascript">
	
	var today = new Date();
	var year = today.getFullYear();
	var month = today.getMonth()+1;
	var date = today.getDate();
	var currentDate = date + "/" + month + "/" + year;
	document.getElementById("createdDate").value = currentDate;
	</script>
</body>
</html>