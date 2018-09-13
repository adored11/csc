<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" type="text/css" href="/eMembership/resources/css/login.css">

	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
    	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      	</script>
    	<![endif]-->
</head>
<body>
	<div>
		<h1>
			Irvine#1 Celtic Sports Club
		</h1>
		<h1>Member's Zone</h1>
			<!-- sec:authentication var="principal" property="principal" /-->
		
		${principal.username}
		<div id="homeScreenButtons">	
			<a href="myDetails.html"> <img src="./resources/images/greenButton_login.png" alt="Login"/> </a>
			<a href="myDetails.html"> <img src="./resources/images/greenButton_reg.png" alt="Register"/> </a>
		</div>
		
	</div>

	<script type="text/javascript"> </script>
	<script src="jquery-1.8.3.js"> </script>
	<script src="assets/js/bootstrap.js"> </script>
</body>
</html>
