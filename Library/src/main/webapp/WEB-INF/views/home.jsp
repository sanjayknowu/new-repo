<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>Library</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">TECHCHEFS 6</a>

    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/Library/">Home</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
  <center><h3>Welcome to Library</h3></center>
  <p></p>
</div>

<form action="/Library/login" method="post">
	<table>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="lMail"><br /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="lPass"><br /></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="login"></td>
				</tr>
				</table>
	</form>
	<p>${result}</p>
<!-- 	<script type="text/javascript"> -->
<!--  	alert("logged succesfully") -->
<!-- 	</script> -->
</body>
</html>
