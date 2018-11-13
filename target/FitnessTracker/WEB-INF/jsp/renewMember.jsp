<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MemberShip Form</title>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	margin: 16px
}
</style>

<link rel="stylesheet" type="text/css" href="/eMembership/resources/css/login.css">
</head>
<body>
<h1>Irvine No.1 Celtic Sports Club</h1>
<hr>
<h2>Membership Renewal Form</h2>
<form:form commandName="renewMember">
<form:errors path="*" cssClass="errorblock" element="div" />
<table>
		<tr>
			<td>Membership No: </td>
			<td><form:input path="memberNo"/></td>
		</tr>
		<tr>
			<td>FirstName: </td>
			<td><form:input path="name"/></td> <!-- cssErrorClass="error"/></td-->
			<!-- td><form:errors path="name" cssClass="error"/></td-->
		</tr>
		<tr>
			<td>Surname: </td>
			<td><form:input path="surname"/></td>
		</tr>
		<tr>
			<td>Address Line 1: </td>
			<td><form:input path="address1"/></td>
		</tr>
		<tr>
			<td>Address Line 2: </td>
			<td><form:input path="address2"/></td>
		</tr>
		<tr>
			<td>Town: </td>
			<td><form:input path="town"/></td>
		</tr>
		<tr>
			<td>Postcode: </td>
			<td><form:input path="postcode"/></td>
		</tr>
		<tr>
			<td>Email: </td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>DOB: </td>
			<td><form:input path="dob"/></td>
		</tr>
		<tr>
			<td>Tel: </td>
			<td><form:input path="telephone"/></td>
		</tr>
		<tr>
			<td>Start Date: </td>
			<td><form:input path="startDate"/></td>
		</tr>
		<tr>
			<td>Next Renewal Date: </td>
			<td><form:input path="nextRenewalDate"/></td>
		</tr>
		<tr>	
			<td colspan="3">
			<input type="submit" value="Renew" class="buttons"/></td>
		</tr>
</table>
</form:form>


</body>
</html>