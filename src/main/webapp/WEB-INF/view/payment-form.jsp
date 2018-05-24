<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

	<!-- 
	<div id="container-fluid">
		<h3>Save Payment</h3>

		<form:form action="savePayment" modelAttribute="payment" method="POST">
			<form:hidden path="id" />
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>

					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>

					<tr>
						<td><label>Date:</label></td>
						<td><form:input path="date" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="btn btn-primary" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		</div>
 -->
	<div class="bootstrap-iso">
		<div class="container-fluid">
			<h3>Save Payment</h3>
			<div class="row">
				<div class="col-md-6 col-sm-6 col-xs-12">
					<form:form action="savePayment" class="form-horizontal"
						modelAttribute="payment" method="POST">
						<form:hidden path="id" />

						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="name">
								Name <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"> </i>
									</div>
									<form:input class="form-control" path="name" id="name" name="name" type="text" />
								</div>
							</div>

						</div>

						<div class="form-group ">
							<label class="control-label col-sm-2 requiredField" for="name">
								Description <span class="asteriskField"> * </span>
							</label>
							<div class="col-sm-10">
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"> </i>
									</div>
									<form:input class="form-control" path="description" id="description" name="description" type="text" />
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
										<i class="fa fa-calendar"> </i>
									</div>
									<form:input class="form-control" id="date" name="date" path="date" placeholder="DD/MM/YYYY" type="text" />
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
			
			<p>
				<a href="${pageContext.request.contextPath}/payment/list">Back to payments</a>
			</p>
		</div>
	</div>

</body>

</html>
