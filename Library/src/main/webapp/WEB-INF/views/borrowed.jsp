<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
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
<script src="resources/js/renew.js" type="text/javascript"></script>
<script src="http://www.datejs.com/build/date.js" type="text/javascript"></script>
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
			<li><a href="/Library/checkmember">Member</a></li>
<!-- 			<li><a href="/Library/checkBooks">Books Availability</a></li> -->
<!-- 			<li><a href="#">TakeIn</a></li> -->
			<li class="active"><a href="/Library/borrowed">Borrowed</a></li>
			<li><a href="/Library/members">Add Member</a></li>
			<li><a href="/Library/book">Add Books</a></li>
<!-- 			<li><a href="/Library/details">Details</a></li> -->
			<li><a href="/Library/memberList">Member Details</a></li>
			<li><a href="/Library/bookList">Books Details</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<h3>Borrowed Page</h3>
		<form action="/Library/borrowedList" method="post">
			<table id ="table1">
				<tr>
					<td>Member Id</td>
					<td><input id="empid" type="text" name="employeeId"><br /></td>
				</tr>
				<br />
				<br />
				<tr>
					<td></td>
					<td><input type="submit" id="button" value="submit"></td>
				</tr>
			</table>
		</form>
		<br /> <br />
		<!-- 		<table id="devicecentral" class="table"> -->
		<!-- 							</table> -->
		<c:choose>
			<c:when test="${empty listofbarrow}">
			</c:when>
			<c:otherwise>

				<table style="border: 1px solid black" id = "tid">
					<tr>
						<!-- 						<th style="border: 1px solid black">ID</th> -->
						<th style="border: 1px solid black" align="center" width="300px">Member
							Id</th>
						<th style="border: 1px solid black" align="center" width="300px">Member
							Name</th>
						<th style="border: 1px solid black" align="center" width="300px">Book
							Id</th>
						<th style="border: 1px solid black" align="center" width="300px">Book
							Name</th>
						<th style="border: 1px solid black" align="center" width="300px">Issued
							Date</th>
						<th style="border: 1px solid black" align="center" width="300px">Due
							Date</th>
						<th style="border: 1px solid black" align="center" width="300px">Return</th>
						<th style="border: 1px solid black" align="center" width="300px">Renewed</th>
<!-- 						<th style="border: 1px solid black" align="center" width="300px">LateFees</th> -->
					</tr>
					<c:forEach items="${listofbarrow}" var="employee" >
<%-- 						<form action="/Library/renew/${employee.id}/${employee.mbrId}" --%>
<!-- 							method="post"> -->
							<tr>

								<%-- 							<td style="border: 1px solid black" align="center">${employee.id}</td> --%>
								<td style="border: 1px solid black" align="center" width="300px" id="mid" name="memId">${employee.mbrId}</td>
								<td style="border: 1px solid black" align="center" width="300px" >${employee.mbrName}</td>
								<td style="border: 1px solid black" align="center" width="300px" >${employee.bookId}</td>
								<td style="border: 1px solid black" align="center" width="300px">${employee.bookName}</td>
								<td style="border: 1px solid black" align="center" width="300px">${employee.issuedDate}</td>
								<td style="border: 1px solid black" align="center" width="300px" id="duedateid" name="duedate">${employee.dueDate}</td>

								<td style="border: 1px solid black" align="center" width="300px" class="click"><a
									href="/Library/return/${employee.id}/${employee.mbrId}/${employee.bookId}" onclick="calculate(this.parentNode.parentNode.rowIndex)" id="re" name="return">Return</a></td>


								<td style="border: 1px solid black" align="center" width="300px"><input
									type="submit" value="renewed" onclick="data(this.parentNode.parentNode.rowIndex,${employee.id})"/></td>
								<%-- <td style="border: 1px solid black" align="center" width="300px"><input
									type="submit" id="check" value="CheckFess" formaction = "/Library/return/${employee.id}/${employee.mbrId}/${employee.bookId}" 
									onclick="CallMe(${employee.mbrId})"
									></td> --%>

							</tr>
<!-- 						</form> -->
					</c:forEach>
				</table>
				
				<!-- <script>
				    $(function(){
				        $("#tid tr").click(function(){
				        alert (this.rowIndex);
				        });
				    });
				</script> -->
				
				<script>
				function data(x,id) {
					var devicecentral = $("#tid");
					var index = x;
					var id = id;
					var mid = document.getElementById("tid").rows[index].cells.item(0).innerHTML;
					var bid = document.getElementById("tid").rows[index].cells.item(2).innerHTML;
				    var value = document.getElementById("tid").rows[index].cells.item(5).innerHTML;
					var date = new Date(value);
					var rdate = new Date(date.setDate(date.getDate()+10));
					var cyear = rdate.getFullYear();
					var cmonth = rdate.getMonth()+1;
					var cday = rdate.getDate();
					var merge = cyear+"-"+cmonth+"-"+cday
					alert(merge);
					
					$.ajax({
		  				 contentType: 'application/json; charset=UTF-8',
		  				 dataType: 'json',
		  				 type: 'POST',
		  				 //async: false,
		  				 //processData: false,
 		  				 url: '/Library/renewed/'+id+'?memId='+mid+'&duedate='+merge,
		  				 success: function(responseBO){
		  					console.log(responseBO);
		  					 var devicecentral = $("#tid");
		  					 var theaddevice='<thead><tr><th style="border: 1px solid black" align="center" width="300px">Member Id</th><th style="border: 1px solid black" align="center" width="300px">Member Name</th><th>Book Id</th><th style="border: 1px solid black" align="center" width="300px">Book Name</th><th style="border: 1px solid black" align="center" width="300px">Issued Date</th><th style="border: 1px solid black" align="center" width="300px">Due Date</th><th style="border: 1px solid black" align="center" width="300px">Return</th><th style="border: 1px solid black" align="center" width="300px">Renewed</th></tr></thead>';
		  					 var tsbody='<tbody id="id tbody">';
		  					 var tebody='</tbody>';
		  					 var resultHtml = '';
		  					 var m=1;
		  					 if(responseBO.length==0){
		  						 
		  						alert('No employee found');
		  						 return; 
		  					 }
		  					 for (var i = 0; i < responseBO.length; i++) {
		  						 var employee=responseBO[i];
		  								resultHtml += [
		  										'<tr>',
		  										'<td style="border: 1px solid black" align="center" width="300px">'+employee.mbrId+'</td>',
		  										'<td style="border: 1px solid black" align="center" width="300px">'+employee.mbrName+'</td>',
		  										'<td style="border: 1px solid black" align="center" width="300px">'+employee.bookId+'</td>',
		  										'<td style="border: 1px solid black" align="center" width="300px">'+employee.bookName+'</td>',
		  										'<td style="border: 1px solid black" align="center" width="300px">'+employee.issuedDate+'</td>',
		  										'<td style="border: 1px solid black" align="center" width="300px">'+employee.dueDate+'</td>',
 		  										'<td style="border: 1px solid black" align="center" width="300px"><a href=/Library/return/'+employee.id+'/'+employee.mbrId+'/'+employee.bookId+' onclick="calculate('+m+')" id="re">Return</a></td>',
 		  										'<td style="border: 1px solid black" align="center" width="300px"><input type="submit" value="renewed" onclick="data('+m+','+employee.id+')"/></td>',
		  										'</tr>' ].join("\n"); 
		  						m++;
		  					}
		  					devicecentral.html(theaddevice+tsbody+resultHtml+tebody); 
		  				},
		  				  error: function(){
		  					alert("Error while request..Contact Admin");
		  					
		  				} 
		  				
		  				 });
				};
				</script>
				
				<script>
				function calculate(x) {
					var index = x;
					var oneDayFine = 5;
					/* var datefield = "";
					
					document.getElementById('duedateid').onclick = function (e) {
					    if (this.value != datefield) {
					    
					    	datefield = this.value;
					    }
					    alert("changed date "+datefield);
					}; */
				
					
					/* $("#re").on('click', function() {
						  var val = $('#duedateid').val();
						alert("changed date "+val);
					}); */
					
					/* var table = document.getElementById("tid");
					var row = document.getElementById("tid").rows.length;
					alert("row count "+row);
					var count = parseInt(row-1);
					alert(count);
					var value = document.getElementById("tid").rows[count].cells.item(5).innerHTML;
					alert(value); 
					var d = new Date(value);
					var cyear = d.getFullYear();
					var cmonth = d.getMonth()+1;
					var cday = d.getDate()
					var chdate = cyear+"-"+cmonth+"-"+cday;
					alert(chdate);  */
		
					var value = document.getElementById("tid").rows[index].cells.item(5).innerHTML;
					//alert(value);
					var d = new Date(value);
					var cyear = d.getFullYear();
					var cmonth = d.getMonth()+1;
					var cday = d.getDate()
					var chdate = cyear+"-"+cmonth+"-"+cday;
					alert(chdate);
					//var duedate = $("#duedateid").val();
					//alert("direct date "+duedate);
					var date = new Date();
					var day = date.getDay();
					var month = date.getMonth()+1;
					var year = date.getFullYear();
					var change = year+"-"+month+"-"+day;
					//alert(change);
					var date1 = new Date(chdate);
					var date2 = new Date(change);
					var diff = parseInt((date2 - date1) / (1000 * 60 * 60 * 24));
					//alert("difference is "+diff);
					if (diff > 0) {
						var totalFine = oneDayFine * diff;
						alert("total fine = "+totalFine);
					}
					else {
						alert("No fine");
					}
				}
				
				</script>
				
				<script>
				function CallMe(id) {
				//$('#table1').remove();
				var id = id;
				alert(id);
				var memberId = $("#mid").val();
				alert(memberId);
				var duedate = $("#duedateid").val();
				alert(duedate);
				var date = new Date();
				var day = date.getDay();
				//alert("day "+date);
				var month = date.getMonth()+1;
				//alert("month "+month);
				var year = date.getFullYear();
				//alert("year "+year);
				var change = year+"-"+month+"-"+day;
				//alert("cahge date "+change);
				var date1 = new Date(duedate);
				var date2 = new Date(change);
				//var oneDay = 24 * 60 * 60 * 1000;
				var diff = parseInt((date2 - date1) / (1000 * 60 * 60 * 24));
				//var diff = Math.abs((date2.getTime() - date1.getTime()) / (oneDay));
				alert("difference is "+diff);
				var oneDayFine = 5;
				if (diff > 0) {
					alert("entering...");
					var totalFine = oneDayFine * diff;
					var devicecentral = $("#tid");
 					var table = '<table>'; 					
 					var tsbody='<tbody>'; 					
 					var data = '';
 					var tebody='</tbody>';
 					var tend='</table>';
					var ediv ='</div>';
 					data +=['<tr>',
 							'<td>Total Fine</td><td><input id="fineid" name="fine" readonly="readonly" value='+totalFine+' rs></td></tr>',
							'<tr><td></td><td><input id="click" type="submit" name="submit" value="submit" onclick=""></td>',
							'</tr>'].join("\n");
					devicecentral.html(tsbody+data+tebody);
					//$("#devicecentral").html("<div><table><body><tr><td>Total Fine</td><td><input id="fineid" type="text" name="fine" value='+totalFine+'></td><td></td><td><input id="click" type="button" name="submit" value="submit"></td></tr></body></table></div>");
				}
				else {
					alert("No fine");
				}
				};
				</script>
				<script>
				function call(){
					$('#tid').remove();
					var mid = id;
					alert("mid"+id);
					$.ajax({
		  				 contentType: 'application/json; charset=utf-8',
		  				 dataType: 'json',
		  				 type: 'POST',
		  				 url: '/Library/borrowedList?employeeId='+mid,
		  				 success: function(responseBO){
		  					 var devicecentral = $("#tid");
		  					 var theaddevice='<thead><tr><th>Member Id</th><th>Member Name</th><th>Book Id</th><th>Book Name</th><th>Issued Date</th><th>Due Date</th><th>Return</th><th>Renewed</th></tr></thead>';
		  					 var tsbody='<tbody id="id tbody">';
		  					 var tebody='</tbody>';
		  					 var resultHtml = '';
		  					 var m=1;
		  					 if(responseBO.length==0){
		  						 
		  						alert('No employee found ');
		  						 return; 
		  					 }
		  					 for (var i = 0; i < responseBO.length; i++) {
		  						 var employee=responseBO[i];
		  								resultHtml += [
		  										'<tr>',
		  										'<td>'+employee.mbrId+'</td>',
		  										'<td>'+employee.mbrName+'</td>',
		  										'<td>'+employee.bookId+'</td>',
		  										'<td>'+employee.bookName+'</td>',
		  										'<td>'+employee.issuedDate+'</td>',
		  										'<td ><input id="duedateid" type="date" name="duedate" value='+employee.dueDate+'></td>',
// 		  										'<td><input type="button" id="click1" value="return" onclick="action('+employee.id+','+m+')"></td>',
		  										'<td><button type="button" value="return" /></td>',
// 		  										'<td><input id="click2" type="button" name="renewedBtn" value="renewed" ></td>',
		  										'</tr>' ].join("\n"); 
		  						m++;
		  					}
		  					devicecentral.html(theaddevice+tsbody+resultHtml+tebody); 
		  				},
		  				  error: function(){
		  					alert("Error while request..Contact Admin");
		  					
		  				
		  				} 
		  				
		  				 });
				};
				
				</script>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
