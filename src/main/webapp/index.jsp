<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Le styles -->
<link href="assets/css/bootstrap.css" rel="stylesheet">

<style>	
.container {
color: black;
	background-color: white;
	font-family: Cooper;
	text-align: center;
}	
 .mainButtons {
    display: inline-block;
    margin-left: auto;
    margin-right: auto;
    
}
</style>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      </script>
    <![endif]-->
<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
<style>
</style>
</head>
<body>
	<div class="container">
				<h1>
					Irvine#1 Celtic Sports Club
					<!--sec:authentication property="name" /-->
				</h1>
				<h1>Member's Zone</h1>
			
					<!-- If you are an existing member and wish to register for online
					membership renewal click <a class="btn btn-primary"
						href="renewMember.html">here</a> <br> <br> If you have
					already registered and wish to renew your annual membership click <a
						class="btn btn-primary" href="renewMember.html">here</a> <br>
					<br>
					<!-- sec:authorize ifAnyGranted="ROLE_ADMIN" -->
					<!-- Admin User - click <a class="btn btn-primary"
						href="userAdminArea.html">here</a> to edit user details -->
					<!-- sec:authorize -->
					<!-- <br> <br> <a class="btn btn-warning"
						href="j_spring_security_logout">Logout >></a> -->
					<div id="mainButtons">	
					<a href="renewMember.html"> <img src="./resources/images/greenButton_login.png" alt="Login"/> </a>
					<a href="renewMember.html"> <img src="./resources/images/greenButton_reg.png" alt="Register"/> </a>
					</div>
				
			<!-- /div -->
		<!-- /div -->
		
	</div>

	<script type="text/javascript">
		
	</script>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="assets/js/bootstrap.js">
		
	</script>
</body>
</html>
