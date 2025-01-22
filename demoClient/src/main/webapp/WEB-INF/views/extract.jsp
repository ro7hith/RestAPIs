<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<m:Master title="Extract">
<jsp:attribute name="head">
<script>
$(document).ready(function()
{
	
	 $("#empno").blur(function()
			 {
				var eno=$("#empno").val();	 
				 $.ajax({
		 				type:"Get",
		 				url:"http://localhost:9000/fetchall/"+eno,
		 				dataType:"json",
		 				contentType:"application/json",
		 				success:function(data)
		 				{
		 				$("#empno").val(data.empno);
		 				$("#ename").val(data.ename);
		 				$("#sal").val(data.sal);
		 				$("#dob").val(data.dob);
		  				$("#email").val(data.email);
		 				document.getElementById("message").innerText="";		
		 				
		 				},
		 				error:function(m,err)
		 				{
		 					$("#empno").val("");
			 				$("#ename").val("");
			 				$("#sal").val("");
			 				$("#dob").val("");
			 				$("#email").val("");
			 				document.getElementById("message").innerText=m.responseText;		
		 								 				
		 				}
	 					});// End of Ajax
	 		});//End of Empno blur
	 		
	 		$("#update").click(function(){
	 			var eno=$("#empno").val();	 
					
	 			var e={
	 					empno:$("#empno").val(),
	 					ename:$("#ename").val(),
	 					sal:$("#sal").val(),
	 					dob:$("#dob").val(),
	 					email:$("#email").val()
	 					};
	 		
	 			
			
	 			$.ajax({
	 				type:"Put",
	 				url:"http://localhost:9000/Updateemp/"+eno,
	 				data:JSON.stringify(e),
	 				dataType:"json",
	 				contentType:"application/json",
	 				success:function(data)
	 				{
	 				document.getElementById("message").innerText=
	 				"The following details are updated\n"
	 				+"Empno :"+data.empno+"\n"
	 				+"Ename :"+data.ename+"\n"
	 				+"Sal :"+data.sal+"\n"
	 				+"Dob :"+data.dob+"\n"
	 				+"Email :"+data.email+"\n";		
	 				},
	 				error:function(m,err)
	 				{
	 					$("#empno").val("");
		 				$("#ename").val("");
		 				$("#sal").val("");
		 				$("#dob").val("");
		 				$("#email").val("");
		 				document.getElementById("message").innerText=m.responseText;		
	 								 				
	 				}	
	 			});	
	 			
	 		});
 });// End of JQuery
//$("[name='empno']").blur(function(){
//	alert("hello"); 
//});


 </script>
</jsp:attribute>
<jsp:attribute name="content">



<table class="table table-bordered">
<tr>
<td>Empno</td>
				<td><input type="text" id="empno"></td>
</tr>
<tr>
<td>Ename</td>
				<td><input type="text" id="ename"></td>
</tr>
<tr>
<td>Sal</td>
				<td><input type="text" id="sal"></td>
</tr>
<tr>
<td>Dob</td>
				<td><input type="date" id="dob"></td>
</tr>
<tr>
<td>Email</td>
				<td><input type="text" id="email"></td>
</tr>
</table>
	<input type="submit"  id="update" value="Update" class="btn btn-light">
<div id="message"></div>			
</jsp:attribute>
</m:Master>