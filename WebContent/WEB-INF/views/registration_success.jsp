<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
  <title>Registration Successful</title>
	
  <script type="text/javascript" src="<c:url value="/webjars/jquery/1.9.1/jquery.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>  
	
</head>
<body style="font-family: Calibri;">

	<nav style="background-color: #2E008B; color: #FEFEFE" class="navbar navbar-expand-lg static-top">
		<div class="container">
			<h1 class="text-center">Phoebus Bank</h1>
		</div>
	</nav>

	<div class="container">
		  <div id="back_to_welcome_page_div">
		  	<a href="home" style="font-size:20px">Back to home page</a>
		  </div>
		<div class="row text-center">
	        <div class="col-sm-20">
		        <h2 style="color:green">Registration Successful!</h2>
		        <h3>Dear, ${customer.firstname} ${customer.surname}</h3>
		        <p style="font-size:20px;color:brown;">Thank you for registering! </p>
	     	</div>
	    </div>
	</div>

</body>
</html>