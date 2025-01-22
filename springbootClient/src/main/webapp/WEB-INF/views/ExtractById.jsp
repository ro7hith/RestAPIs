<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<m:Master title="Extract">
	<jsp:attribute name="head"></jsp:attribute>
	<jsp:attribute name="content">
<form action="fetchById">
<input type="text" name="empno">

<input type="submit">
<c:if test="${employee!=null}">
	<table>
		<tr>
					<th>Empno</th>
					<th>Ename</th>
					<th>Salary</th>
					<th>Date of Birth</th>
					<th>Email</th>
				</tr>
		<tr>
		<td>${employee.empno}</td>
		<td>${employee.ename}</td>
		<td>${employee.sal}</td>
		<td>${employee.dob}</td>
		<td>${employee.email}</td>
		</tr>
	
	</table>


</c:if>

<c:if test="${msg!=null }">
${msg}
</c:if>

</form>
</jsp:attribute>
</m:Master>