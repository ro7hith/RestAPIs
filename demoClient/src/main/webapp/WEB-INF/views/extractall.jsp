<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="m"%>
<m:Master title="Extract">
<jsp:attribute name="head">
<script>
$(document).ready(function()
{
	$("#fetch").click(function(){
		
		 $.ajax({
				type:"Get",
				url:"http://localhost:9000/fetchall",
				dataType:"json",
				contentType:"application/json",
				success:function(data)
				{
					$("#tbldata").empty();
					$("#tbldata").append("<tr><th>Empno</th><th>Ename</th><th>sal</th><th>dob</th><th>email</th></tr>");
					alert(data.length);
					for(i=0;i<data.length;i++)
						{
						str="";
						str="<tr><td>"+data[i].empno+"</td>";
						str=str+"<td>"+data[i].ename+"</td>";
						str=str+"<td>"+data[i].sal+"</td>";
						str=str+"<td>"+data[i].dob+"</td>";
						str=str+"<td>"+data[i].email+"</td></tr>";
						alert(str);
						$("#tbldata").append(str);
						
						}
				
					
				},
				error:function(m,err)
				{
					alert(m.responseText);			
				}
				});// End of Ajax

		
		
		
	});


});
</script></jsp:attribute>
<jsp:attribute name="content">
<input type="submit" id="fetch" value="fetch">
<table id="tbldata"></table>
</jsp:attribute>
</m:Master>