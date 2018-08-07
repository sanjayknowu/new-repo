<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<style>
table.firstTable {
	border: 1px solid black;
}

td.firstTable {
	border: 1px solid black;
}

th.firstTable {
	border: 1px solid black;
}
</style>
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
<!-- 			<li><a href="#">TakeIn</a></li> -->
			<li><a href="/Library/borrowed">Borrowed</a></li>
			<li><a href="/Library/members">Add Member</a></li>
			<li><a href="/Library/book">Add Books</a></li>
			<li class="active"><a href="/Library/memberList">Member Details</a></li>
			<li><a href="/Library/bookList">Books Details</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<h3>Member Details</h3>
			<table style="border: 1px solid black" id = "tid">
					<tr>
						<th style="border: 1px solid black" align="center" width="200px">Member Id</th>
						<th style="border: 1px solid black" align="center" width="200px">Member Name</th>
						<th style="border: 1px solid black" align="center" width="200px">Phone No</th>
						<th style="border: 1px solid black" align="center" width="200px">Date</th>
					</tr>
					<c:forEach items="${listOfMembers}" var="member" >
								<tr>
								<td style="border: 1px solid black" align="center" width="200px" >${member.mId}</td>
								<td style="border: 1px solid black" align="center" width="200px" >${member.mName}</td>
								<td style="border: 1px solid black" align="center" width="200px" >${member.phNo}</td>
								<td style="border: 1px solid black" align="center" width="200px" >${member.date}</td>

							</tr>
					</c:forEach>
				</table>
		<br /> 
	</div>
</body>
</html>
