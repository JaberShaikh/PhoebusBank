<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

  <title>Welcome Page</title>

  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">

  <script type="text/javascript" src="<c:url value="/webjars/jquery/1.9.1/jquery.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>  
  <link href="<c:url value="/webjars/font-awesome/5.9.0/css/all.css"/>" rel="stylesheet">
  
</head>

<body style="font-family: Calibri;">

<nav style="background-color: #2E008B; color: #FEFEFE" class="navbar navbar-expand-lg static-top">
	<div class="container">
		<h1 class="text-center">Welcome Phoebus Bank Admini Page</h1>
	</div>
</nav>

<div class="container">
<div class="card">
<article class="card-bodymx-auto" style="max-width: 800px; background:#EAE8FF; color:black">
	<h4 class="card-title mt-3 text-left">Administration Tools</h4>
	<form id="welcome_form" name="welcome_form" action="welcome" method="post"> 
     <div class="form-group">
        <div class="col-xs-12">
              <button style="background-color: #2E008B; color: #FEFEFE" id="customer_registration_btn" class="btn btn-lg" type="button" 
              	name="customer_registration_btn"><i class="glyphicon glyphicon-ok-sign"></i> Register Customer</button>
              <button style="background-color: #2E008B; color: #FEFEFE" id="search_customer_btn" class="btn btn-lg" type="button" 
              	name="search_customer_btn"><i class="glyphicon glyphicon-ok-sign"></i> Search Customer</button>
         </div>
     </div>
  </form>
 </article>
  </div> 
 </div> 
<script type="text/javascript">
$(document).ready(function() {

	$("#customer_registration_btn").click(function(event){
		document.welcome_form.action = 'customer_registration';
		document.welcome_form.submit();
	});
	$("#search_customer_btn").click(function(event){
		document.welcome_form.action = 'search_customer';
		document.welcome_form.submit();
	});
	
});

</script>
</body>
</html>