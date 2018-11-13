<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Le styles -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */
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
body {
			color: black;
			background-color: white;
			text-align: center;
			
		}	
		.loginImage {
			position: relative;
			text-align: center;
			color: white;
		}
		.loginImageText {
			position: absolute;
			top: 50%;
			left: 50%;
			transform: translate(-50%, -50%);
		}
		
		.loginForm {
			text-align: center;
		}
		
		form {
			clear:both;
			max-width:15%;
			margin:0 auto;
			display:block;
			//font-family:Comic Sans Ms;
			text-align:center;
		}
</style>
</head>
<body onload='document.f.j_username.focus();'>
	<div class="container">
		<div class="hero-unit">
			<div>
				<h1>
					IrvineNo1 Celtic Sports Club Membership Zone
					<!--sec:authentication property="name" /-->
				</h1>
				<c:if test="${not empty error}">
					<div class="errorblock">
						Your login was unsuccessful. <br />
						Caused: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message }
					</div>
				</c:if>
				<p>
					<div class="loginImage">
						<img src="./resources/images/greenWhitebutton.jpg">
						<div class="loginImageText">LOGIN</div>
					</div>
					
					<form action="j_spring_security_check" name="f" method="post">
					<!-- input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/-->
					<table>
						<tr>
							<td><input type="text" name="j_username" placeholder="username"></td>
						</tr>
						
						<tr>
							<td><input type="password" name="j_password" placeholder="password"></td>
						</tr>
						<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
						<tr>
							<td colspan="2"><a href="renewMember.html"></a> <input type="submit" id="submit" name="Submit" value="Login"></td>
						</tr>

					</table>
				</form>
				
					 <br> <br> If you are an existing member and wish to register for online
					membership renewal click <a class="btn btn-primary"
						href="renewMember.html">here to register</a> 
					<br> <br> <a class="btn btn-warning"
						href="j_spring_security_logout">Logout</a>
						
						<p>If you have
					already registered and wish to renew your annual membership click <a
						class="btn btn-primary" href="renewMember.html">here</a> <br></p>
						
				
			</div>
		</div>
		<div></div>
	</div>
	<script type="text/javascript">
    document.getElementById("submit").onclick = function () {
        location.href = "renewMember.html";
    };
	</script>

	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="assets/js/bootstrap.js">
		
	</script>
</body>
</html>
