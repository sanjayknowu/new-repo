<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>Library</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">TECHCHEFS</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/Library/">Home</a></li>
<!-- 			<li><a href="/Library/checkmember">Member</a></li> -->
<!-- 			<li><a href="/Library/checkBooks">Books Availability</a></li> -->
			<li class="active"><a href="/Library/issue">TakeIn</a></li>
			<li><a href="/Library/borrowed">Borrowed</a></li>
<!-- 			<li><a href="/Library/members">Add Member</a></li> -->
<!-- 			<li><a href="/Library/book">Add Books</a></li> -->
		</ul>
	</div>
	</nav>

	<div class="container">
		<h3>Enter Details</h3>
		<form action="/Library/assignbook" method="post">
			<table>
				<tr>
					<td>Member Id</td>
					<td><input type="text" name="mbrId"><br /></td>
				</tr>
					<tr>
					<td>Member Name</td>
					<td><input type="text" name="mbrName"><br /></td>
				</tr>
				<tr>
					<td>Book Id</td>
					<td><input type="text" name="bookId"><br /></td>
				</tr>
				<tr>
					<td>Book Name</td>
					<td><input type="text" name="bookName"><br /></td>
				</tr>
				<tr>
					<td>Issued Date</td>
					<td><input id = "startDate" type="date" name="issuedDate" readonly="readonly"><br /></td>
				</tr>
				<tr>
					<td>End Date</td>
					<td><input id = "endDate" type="date" name="endDate" readonly="readonly"><br /></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="submit"></td>
				</tr>
			</table>
		</form>
<%-- 		<p>${result}</p> --%>
	</div>
	<script>
	var min = document.getElementById('startDate').valueAsDate = new Date();
	var max = document.getElementById('endDate').valueAsDate = new Date(min.setDate(min.getDate()+10));
</script>
</body>
</html>
