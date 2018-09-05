<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Existing Member Renewal Details</title>
</head>
<body>
<h1>Existing Member Details</h1>
<!--
<form:form commandName="exercise">
	<table>
		<tr>
			<td><spring:message code="goal.text"/></td>
			<td><form:input path="minutes"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Enter Exercise"/>
			</td>	
		</tr>
	</table>
</form:form>
-->

<p>${memberDetails.name}</p>
<p>${memberDetails.surname}</p>
<p>${memberDetails.address}</p>
<p>${memberDetails.email}</p>
<p>${memberDetails.memberNo}</p>
<p>${memberDetails.dob}</p>
<p>${memberDetails.telephone}</p>


</body>
</html>