<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"> </script>
    <link rel="stylesheet" type="text/css" href="/eMembership/resources/css/login.css">
 </head>
 <body>
    <h1>Irvine No.1 Celtic Sports Club</h1>
	<hr>
	<h2>Your Details</h2>
    <table id="userdetailstable">
        <tr>
			<td>Membership No: </td>
			<td><c:out value='${memberDetails.memberNo}' /></td>			
		</tr>
		<tr>
			<td>FirstName: </td>
			<td><c:out value='${memberDetails.userName}' /></td>
		</tr>
		<tr>
			<td>Surname: </td>
			<td><c:out value='${memberDetails.surname}' /></td>
		</tr>
		<tr>
			<td>Address Line 1: </td>
			<td><c:out value='${memberDetails.address_1}' /></td>
		</tr>
		<tr>
			<td>Address Line 2: </td>
			<td><c:out value='${memberDetails.address_2}' /></td>
		</tr>
		<tr>
			<td>Town: </td>
			<td><c:out value='${memberDetails.town}' /></td>
		</tr>
		<tr>
			<td>Postcode: </td>
			<td><c:out value='${memberDetails.postcode}' /></td>
		</tr>
		<tr>
			<td>Email: </td>
			<td><c:out value='${memberDetails.email}' /></td>
		</tr>
		<tr>
			<td>DOB: </td>
			<td><c:out value='${memberDetails.dob}' /></td>
		</tr>
		<tr>
			<td>Tel: </td>
			<td><c:out value='${memberDetails.telephone}' /></td>
		</tr>
		<tr>
			<td>Start Date: </td>
			<td><c:out value='${memberDetails.startDate}' /></td>
		</tr>
		<tr>
			<td>Next Renewal Date: </td>
			<td><c:out value='${memberDetails.nextRenewalDate}' /></td>
		</tr>
    </table>
 	<p>Please confirm details are correct </p>
 	<input type="submit" name="edit" value="Edit Details" class="Ed_Conf_Details" >
 	<input type="submit" name="confirm" value="Confirm & Renew" class="Ed_Conf_Details">
 	
 </body>
</html>
 
 