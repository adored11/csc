<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>IrvineCSC Login Page</title>
	<style type="text/css">
	.errorblock {
		color: #ff0000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
	</style>
	<link rel="stylesheet" type="text/css" href="/eMembership/resources/css/login.css">
</head>

<body onload='document.f.j_username.focus();'>
	<h1>Irvine#1 Celtic Sports Club</h1>
	<h1>Login</h1>
	
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login was unsuccessful. <br />
			Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
		</div>
	</c:if>
	<% System.out.println("login.jsp before form tag") ; %>
	<form action="login" name="f" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				
				<td><input type="text" name="username" placeholder="username" class="userdetailsTextbox"></td>
			</tr>
			
			<tr>
				
				<td><input type="password" name="password" placeholder="password" class="userdetailsTextbox"></td>
			</tr>
			<tr></tr><tr></tr>
			<tr>
				<td colspan="2"><input type="submit" name="Submit" value="LOGIN" class="buttons"> </td>
			</tr>
			
		</table>
	
	</form>
	<% System.out.println("login.jsp after form tag") ; %>
	<p> Forgotten password? Click <a href="resetPassword.html" >here</a> to Reset</p>
	<p> Still to Register? Click <a href="register.html" >here</a></p>
	
</body>
</html>