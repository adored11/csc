<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Form</title>

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
<h2>Add/Update Member Details Form</h2>
<br>
<h3>Search By:</h3>
<form:form id="adminSearch">

<table>
		<tr>
			<td>Membership No: </td>
			<td><input type="text" /></td>
		</tr>
		<tr></tr><tr></tr>
		
		<tr>	
			<td colspan="3">
			<input type="submit" value="Search" class="buttons" /></td>
		</tr>
</table>
</form:form>


</body>
</html>