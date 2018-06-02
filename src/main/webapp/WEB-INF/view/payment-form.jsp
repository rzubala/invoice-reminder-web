<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>

<head>
<title>Save Payment</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="icon" href="${pageContext.request.contextPath}/resources/img/sale-time.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/payment-form.css"/> 

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/payment-form.js"></script>

</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading" style="text-align: center;">
						<div style="font-size: 30px;">
							Pay on time<img
								src="${pageContext.request.contextPath}/resources/img/sale-time.svg"
								width="40px" height="40px" style="margin-left: 10px;">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="bootstrap-iso">
		<div class="container-fluid">
		
			<div class="panel panel-info">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-9" style="font-size: 16px; padding-top: 8px;">
									Save Payment
								</div>
						</div>
					</div>
								
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<form:form action="savePayment" class="form-horizontal"
							modelAttribute="payment" method="POST">
							<form:hidden path="id" />
							    
						    <div class="form-group">
					        	<div class="col-xs-15">
					            	<div>								
										<c:if test="${validationError != null}">
											<div class="alert alert-danger col-xs-offset-1 col-xs-10">
												${validationError}
											</div>
										</c:if>
						            </div>
						        </div>
						    </div>
	
							<div class="form-group ">
								<label class="control-label col-sm-2 requiredField" for="name">
									Name <span class="asteriskField"> * </span>
								</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fas fa-edit" style="width:16px;"> </i>
										</div>
										<form:input class="form-control" path="name" id="name" name="name" type="text" />
									</div>
								</div>
							</div>
	
							<div class="form-group ">
								<label class="control-label col-sm-2 requiredField" for="description">
									Description
								</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fas fa-edit" style="width:16px;"> </i>
										</div>
										<form:input class="form-control" path="description" id="description" name="description" type="text" />
									</div>
								</div>
							</div>
						
							<div class="form-group ">
									<label class="control-label col-sm-2 requiredField" for="amount">
										Amount <span class="asteriskField"> * </span>
									</label>
									<div class="col-sm-10">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fas fa-money-bill-alt" style="width:16px;"> </i>
										</div>
										<form:input class="form-control" path="amount" id="amount" name="amount" type="number" />
									</div>
								</div>
							</div>
							
							<div class="form-group ">
								<label class="control-label col-sm-2 requiredField" for="name">
									Currency <span class="asteriskField"> * </span>
								</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fas fa-dollar-sign" style="width:16px;"> </i>
										</div>
										<form:input class="form-control" path="currency" id="currency" name="currency" type="text" />
									</div>
								</div>
							</div>						
	
							<div class="form-group ">
								<label class="control-label col-sm-2 requiredField" for="date">
									Date <span class="asteriskField"> * </span>
								</label>
								<div class="col-sm-10">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="fa fa-calendar" style="width:16px;"> </i>
										</div>
										<form:input class="form-control" id="date" name="date" path="date" placeholder="DD/MM/YYYY" type="text" />
									</div>
								</div>
							</div>
	
							<div class="form-group ">
								<label class="control-label col-sm-2" for="paid">
									Paid
								</label>
								<div class="col-sm-10">
									<div class="input-group" style="margin-top: 5px;">
										<form:checkbox class="form-check-input" path="paid" id="paid" name="paid" />									
									</div>
								</div>
							</div>
	
							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-2">
									<input style="display: none" type="text" />
									<button class="btn btn-primary " name="submit" type="submit">Save</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			
			<button onclick="window.location.href='list'; return false;" class="btn btn-info btn-md">
	  			<i class="glyphicon glyphicon-log-out"></i> Back to payments
			</button>
		</div>
	</div>

</body>

</html>
