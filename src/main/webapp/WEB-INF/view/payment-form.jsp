<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Payment</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="icon" href="${pageContext.request.contextPath}/resources/img/sale-time.ico">

<!-- Reference Bootstrap files -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	
	<div id="container-fluid">
		<h3>Save Payment</h3>

		<form:form action="saveCustomer" modelAttribute="payment" method="POST">
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
		
		<p>
			<a href="${pageContext.request.contextPath}/payment/list">Back to list</a>
		</p>
		
	</div>
</body>

</html>
