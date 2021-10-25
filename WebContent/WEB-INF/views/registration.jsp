<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

  <title>Customer Registration</title>

  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">

  <script type="text/javascript" src="<c:url value="/webjars/jquery/1.9.1/jquery.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>  
  <link href="<c:url value="/webjars/font-awesome/5.9.0/css/all.css"/>" rel="stylesheet">
  
</head>

<body style="font-family: Calibri;">

<nav style="background-color: #2E008B; color: #FEFEFE" class="navbar navbar-expand-lg static-top">
	<div class="container">
		<h1 class="text-center">Phoebus Bank Registration</h1>
	</div>
</nav>

<div class="container">
  <div id="back_to_welcome_page_div">
  	<a href="home" style="font-size:20px">Back to home page</a>
  </div>
<div class="card">
<article class="card-bodymx-auto" style="max-width: 800px; background:#EAE8FF; color:black">
	<h4 class="card-title mt-3 text-left">Please add your registration details</h4>
	<form:form id="save_customer" name="save_customer" action="save_customer" method="post" modelAttribute="customer"> 

	  <div class="form-group row">
	    <label for="firstname" class="col-sm-3 col-form-label">Firstname <i class="fa fa-asterisk text-danger"></i></label>
	    <div class="col-sm-3">
	        <form:input type="text" style="text-transform: capitalize;" id="firstname" name="firstname" path="firstname" 
	        	placeholder="Enter Firstname" class="form-control input-sm floatlabel" onblur="validate()"></form:input>
	        	<span style="color:red" class="firstname-validation validation-error"></span> 
	    </div>
	  </div>          
	  <div class="form-group row">
	    <label for="surname" class="col-sm-3 col-form-label">Surname <i class="fa fa-asterisk text-danger"></i></label>
	    <div class="col-sm-3">
	        <form:input type="text" style="text-transform: uppercase;" id="surname" name="surname" path="surname"
	        	placeholder="Enter Surname" class="form-control input-sm floatlabel" onblur="validate()"></form:input>
	        	<span style="color:red" class="surname-validation validation-error"></span> 
	    </div>
	  </div>          
	  <div class="form-group row">
	    <label for="account_number" class="col-sm-3 col-form-label">Account Number <i class="fa fa-asterisk text-danger"></i></label>
	    <div class="col-sm-3">
	        <form:input type="text" style="text-transform: uppercase;" id="account_number" name="account_number" path=""
	        	placeholder="Enter Account Number" class="form-control input-sm floatlabel" onblur="validate()"></form:input>
	        	<span style="color:red" class="account_number-validation validation-error"></span> 
	    </div>
	  </div>          
	<hr>
     <div class="form-group">
        <div class="col-xs-12">
           <br>
              <form:button style="background-color: #2E008B; color: #FEFEFE" id="save_customer_btn" class="btn btn-lg" type="submit" 
              	name="save_customer_btn"><i class="glyphicon glyphicon-ok-sign"></i> Save Customer Details</form:button>
         </div>
     </div>

  </form:form>
 </article>
	<script type="text/javascript">

		function checkEmpty(obj) {
			var name = $(obj).attr("name");
			$("."+name+"-validation").html("");	
			$(obj).css("border","");
			if($(obj).val() == "") {
				$(obj).css("border","#FF0000 1px solid");
				$("."+name+"-validation").html("'" + $(obj).attr("placeholder") + "' required");
				return false;
			}
			
			return true;	
		}
		
	    $(document).ready(function() {

			$("#save_customer_btn").click(function(event){
				if (!checkEmpty($('#firstname')) || !checkEmpty($('#surname')) || !checkEmpty($("#account_number")))
	         	{
					event.preventDefault();
	         	}
			});
	    	
	    });
	
	</script> 			
  </div> 
 </div> 
</body>
</html>