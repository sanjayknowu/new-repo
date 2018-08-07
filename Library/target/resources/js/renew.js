 function getempdata(){


$.ajax({
  				 contentType: 'application/json; charset=utf-8',
  				 dataType: 'json',
  				 type: 'POST',
  				 url: '/Library/borrowedList?employeeId='+$("#empid").val(),
  				 success: function(responseBO){
  					 var devicecentral = $("#devicecentral");
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
  										'<td class="nr">'+employee.mbrId+'</td>',
  										'<td>'+employee.mbrName+'</td>',
  										'<td class="nr">'+employee.bookId+'</td>',
  										'<td>'+employee.bookName+'</td>',
  										'<td>'+employee.issuedDate+'</td>',
  										'<td ><input id="endDate" type="date" name="dueDate" value='+employee.dueDate+'></td>',
  										'<td><input type="button" id="click1" value="return" onclick="action('+employee.id+','+m+')"></td>',
//  										'<td><button type="button" class="use-address" value="return" /></td>',
  										'<td><input id="click2" type="button" name="renewedBtn" value="renewed" ></td>',
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

 function action(id,i){
	   var n2 = document.getElementById("devicecentral").rows[i].cells.length;
	   var tableId = id;
	   var bookId='';
	   bookId=document.getElementById("devicecentral").rows[i].cells.item(2).innerHTML;
	   alert("table id "+id);
	   alert("book id "+bookId);
	   $.ajax({
	      contentType: 'text/html; charset=utf-8',
	      dataType: 'json',
	      type: 'POST',
	      url: '/Library/returned?tableId='+tableId+'&bookId='+bookId,
	      success: function(responseBO){
 					 var devicecentral = $("#devicecentral");
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
 										'<td ><input id="date" type="date" name="dueDate" value='+employee.dueDate+'></td>',
 										'<td><input type="button" id="click1" value="return" onclick="action('+employee.id+','+m+')"></td>',
  										'<td><input id="click2" type="button" name="renewedBtn" value="renewed" ></td>',
 										'</tr>' ].join("\n"); 
 						m++;
 					}
 					devicecentral.html(theaddevice+tsbody+resultHtml+tebody); 
 				},
	       error: function(){
	      alert("Error while request..Contact Library");
	     } 
	     
	      });
	};
 
function editdevice(i){
	$('#removal').remove();
	var n2 = document.getElementById("devicecentral").rows[i].cells.length;
	 var str='';
	 var deviceid='';
	 var alternatedeviceid='';
		for(var j=0; j<2;j++){
			if(j==0){
			deviceid=document.getElementById("devicecentral").rows[i].cells.item(j).innerHTML;
			}else{
			alternatedeviceid=document.getElementById("devicecentral").rows[i].cells.item(j).innerHTML;
			}
		}
		alert(deviceid);
		alert(alternatedeviceid);
};

/*function CallMe(id) {

	var duedate = $("#duedateid").val();
	alert("due date "+duedate);
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
	$('#tid').hide();
	if (diff > 0) {
		alert("entering...");
		var totalFine = oneDayFine * diff;
		alert("totalFine "+totalFine);
//		var sdiv = '<div id="divid">'
//		var table = '<table id="divid">';
		var devicecentral = $("#tid");
		var tsbody='<tbody id="id tbody">';
		var tebody='</tbody>';
		var tend='</table>';
//		var ediv ='</div>';
		var data = '';
		data +=['<tr>',
				'<td>Total Fine</td><td><input id="fineid" type="text" name="fine" value='+totalFine+'></td>',
				'<td></td><td><input id="click" type="button" name="submit" value="submit"></td>',
				'</tr>']join("\n");
//		$sdiv.append($table,$tsbody,$data,$tebody,$tend,$ediv);
		devicecentral.html(tsbody+data+tebody+tend);
	}
	else {
		alert("No fine");
	}
	
	};*/

