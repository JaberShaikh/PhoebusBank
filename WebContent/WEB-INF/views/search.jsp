<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

  <title>Customer Search</title>

  <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">

  <script type="text/javascript" src="<c:url value="/webjars/jquery/1.9.1/jquery.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>  
  <link href="<c:url value="/webjars/font-awesome/5.9.0/css/all.css"/>" rel="stylesheet">
  
</head>

<body style="font-family: Calibri;">

<nav style="background-color: #2E008B; color: #FEFEFE" class="navbar navbar-expand-lg static-top">
	<div class="container">
		<h1 class="text-center">Phoebus Bank Search Engine</h1>
	</div>
</nav>

<div class="container">
  <div id="back_to_welcome_page_div">
  	<a href="home" style="font-size:20px">Back to home page</a>
  </div>
<div class="card">
<article class="card-bodymx-auto" style="max-width: 800px; background:#EAE8FF; color:black">
	<h4 class="card-title mt-3 text-left">Search for customer details</h4>
	<form id="search_customer" name="search_customer" action="search_customer" method="post"> 

	  <div class="form-group row">
	    <label for="customer_id" class="col-sm-3 col-form-label">Search Customer ID <i class="fa fa-asterisk text-danger"></i></label>
	    <div class="col-sm-3">
	        <input type="text" style="text-transform: uppercase;" id="customer_id" name="customer_id"
	        	placeholder="Enter Customer ID" class="form-control input-sm floatlabel" onblur="validate()"></input>
	        	<span style="color:red" class="customer_number-validation validation-error"></span> 
	    </div>
	  </div>          
	<hr>
     <div class="form-group">
        <div class="col-xs-12">
           <br>
              <button style="background-color: #2E008B; color: #FEFEFE" id="search_customer_btn" class="btn btn-lg" type="submit" 
              	name="search_customer_btn"><i class="glyphicon glyphicon-ok-sign"></i> Search Customer</button>
         </div>
     </div>
	   	<c:choose>
	   <c:when test = "${not empty search_customer_result}">
	  	<table id="customer_search_result_table" class="table table-striped table-bordered"> 
		    <thead>
		        <tr>
		           <th>Customer ID </th>
		           <th>Firstname </th>
		           <th>Surname </th>
		           <th>Account Number </th>
		        </tr>
		    </thead>
		    <tbody>
			<tr>
               <td>${search_customer_result.customer_id}</td>
               <td>${search_customer_result.firstname}</td>
               <td>${search_customer_result.surname}</td>
				<c:forEach items = "${search_customer_result.customer_accounts}" var="customer_account">
	               <td>${customer_account.account.account_number}</td>
				</c:forEach>
            </tr>
            </tbody>
	  	</table>
	   </c:when>
	   <c:otherwise>
		<h4 class="card-title mt-3 text-left">No customer found</h4>
	   </c:otherwise>
	   </c:choose>
  </form>
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

			$("#search_customer_btn").click(function(event){
				if (!checkEmpty($('#customer_id')))
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