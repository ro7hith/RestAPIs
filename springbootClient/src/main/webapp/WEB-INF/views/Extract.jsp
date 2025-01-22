<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<m:Master title="Extract">
	<jsp:attribute name="head"></jsp:attribute>
	<jsp:attribute name="content">
<form action="fetchAll">
<input type="submit">
<c:if test="${Earray!=null}">
	<table>
		<tr>
					<th>Empno</th>
					<th>Ename</th>
					<th>Salary</th>
					<th>Date of Birth</th>
					<th>Email</th>
				</tr>
		<c:forEach var="e" items="${Earray }">
		<tr>
		<td>${e.empno}</td>
		<td>${e.ename}</td>
		<td>${e.sal}</td>
		<td>${e.dob}</td>
		<td>${e.email}</td>
		</tr>
		</c:forEach>
	</table>


</c:if>

<c:if test="${msg!=null }">
${msg}
</c:if>

</form>
</jsp:attribute>
</m:Master>