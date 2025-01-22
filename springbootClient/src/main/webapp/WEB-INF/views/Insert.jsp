<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<m:Master title="Insert Employee">
	<jsp:attribute name="head"></jsp:attribute>
	<jsp:attribute name="content">
	<f:form modelAttribute="employee" action="InsertEmp">
	<table class="table table-bordered">
	<tr>
					<td class="tdcol">Employee No</td>
					<td class="tdcol"><f:input path="empno" /></td>
					<td class="tdcol"><f:errors path="empno" class="error" /></td>
				</tr>
	<tr>
					<td>Employee Name</td>
					<td><f:input path="ename" /></td>
					<td><f:errors path="ename" class="error" /></td>
				</tr>
	<tr>
					<td>Salary</td>
					<td><f:input path="sal" /></td>
					<td><f:errors path="sal" class="error" /></td>
				</tr>
	<tr>
					<td>Date of Birth</td>
					<td><f:input path="dob" type="date" /></td>
					<td><f:errors path="dob" class="error" /></td>
				</tr>
	<tr>
					<td>Email</td>
					<td><f:input path="email" /></td>
					<td><f:errors path="email" class="error" /></td>
				</tr>
	<tr>
					<td><input type="submit" value="Insert"></td>
				</tr>
	</table>
	
	
	
	
	
	<div class="error">
	<c:if test="${msg!=null }">
		${msg}
	</c:if>
</div>	
	
	</f:form>
	
	
	
	</jsp:attribute>
</m:Master>