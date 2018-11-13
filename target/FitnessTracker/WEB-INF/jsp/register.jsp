<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="/eMembership/resources/css/login.css">
</head>
<body>
	<h1>Irvine No.1 Celtic Sports Club</h1>
	<hr>
	<h2>Membership Renewal Form</h2>
	<h3 id="registerSections">Personal Details:</h3>
	<form:form name="registerDetailsForm" method="post" action="/eMembership/createMember" commandName="loginAndDetails">
		
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		
		<table>
			<tr>
				<td>*Login Name:</td>
				<td><form:input path="userLogin.userName" /></td>
			</tr>
			<tr>
				<td>*Password:</td>
				<td><form:input path="userLogin.password" type="password" /></td>
			</tr>
			<tr>
				<td>*Membership No:</td>
				<td><form:input path="memberDetails.memberNo" /></td>
			</tr>
			<tr>
				<td>*Forename(s):</td>
				<td><form:input path="memberDetails.forename" /></td>
			</tr>
			<tr>
				<td>*Surname:</td>
				<td><form:input path="memberDetails.surname" /></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td class="dob">Month: <form:select
						path="memberDetails.dobMonth" items="${monthsMap}" /></td>
				<td class="dob">Day: <form:input path="memberDetails.dobDay"
						maxlength="2" size="2" placeholder="Day" /></td>
				<td class="dob">Year: <form:input path="memberDetails.dobYear"
						maxlength="4" size="2" placeholder="YYYY" /></td>
			</tr>
		</table>
		
		<br>
		<h3 id="registerSections">Address Details:</h3>
		<table>
			<tr>
				<td>Address Line 1:</td>
				<td><form:input path="memberDetails.address_1" /></td>
			</tr>
			<tr>
				<td>Address Line 2:</td>
				<td><form:input path="memberDetails.address_2" /></td>
			</tr>
			<tr>
				<td>Town:</td>
				<td><form:input path="memberDetails.town" /></td>
			</tr>
			<tr>
				<td>Postcode:</td>
				<td><form:input path="memberDetails.postcode" /></td>
			</tr>
		</table>
		
		<br>
		<h3 id="registerSections">Contact Details:</h3>
		<table id="contactTab">
			<tr>
				<td width=105px>Tel: </td>
				<td width=173px><form:input path="memberDetails.telephone" /></td>
			</tr>
			<tr>
				<td width=105px>Email:</td>
				<td width=173px><form:input path="memberDetails.email" /></td>
			</tr>
		</table>
		<br>
		<br>
		<br>

		<form:input path="authority.authority" type="hidden" value="ROLE_USER" />
		<br>
		<input type="submit" value="Register Details" class="buttonsOpposite" />
	
	</form:form>


</body>
</html>