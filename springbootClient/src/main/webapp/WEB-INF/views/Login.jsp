<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="m"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<m:Master title="Insert Employee">
	<jsp:attribute name="head"></jsp:attribute>
	<jsp:attribute name="content">
	<f:form modelAttribute="Login" action="ValidateLogin">
	<table>
	<tr>
					<td>Username</td>
					<td><f:input path="username" /></td>
					<td><f:errors path="username" class="error"></f:errors></td>
				</tr>
	<tr>
					<td>Password</td>
					<td><f:input path="password" type="password" /></td>
					<td><f:errors path="password" class="error"></f:errors></td>
				</tr>
	<tr>
					<td><input type="submit"></td>
				</tr>
	</table>
	</f:form>
	
	
	</jsp:attribute>


</m:Master>