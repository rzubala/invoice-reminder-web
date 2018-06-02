<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>Payments list</title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/sale-time.ico">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list-payments.css"/> 
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	<script	src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script	src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/list-payments.js"></script>
</head>

<body>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading" style="text-align: center;">
						<div style="font-size:30px;">Pay on time<img src="${pageContext.request.contextPath}/resources/img/sale-time.svg" width="40px" height="40px" style="margin-left: 10px;"></div>
					</div>
					<!-- 
					<div class="panel-body">		
						User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
					</div>
					-->
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-2 col-xs-offset-10">	
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
					<button style="float: right;" type="submit" class="btn btn-info btn-md">
			  			<i class="glyphicon glyphicon-log-out"></i> Logout
					</button>
				</form:form>
			</div>
		</div>	
	
		<security:authorize access="hasAnyRole('USER')">
			<div class="row" style="margin-top: 15px;">
				<div class="col-md-12 col-xs-12 col-s-12">	
					<div class="panel panel-info">
  						<div class="panel-heading">
  							<div class="row">
	  							<div class="col-xs-9" style="font-size: 16px; padding-top: 8px;">
	  								Payments for user: <b><security:authentication property="principal.username"/></b>
  								</div>
  								<div class="col-xs-3">
  								<!-- 
	  								<input style="float: right;" class="btn btn-warning" type="button" value="Add payment" onclick="window.location.href='addPayment'; return false;"/>
								-->
	  								<button style="float: right;" type="button" class="btn btn-warning" onclick="window.location.href='addPayment'; return false;">
	  									<i class="glyphicon glyphicon-plus"></i> Add payment
	  								</button>
	  								
								</div>
							</div>							
  						</div>
  						<div style="margin-top: 10px;">
  							<!--
  							TODO filtering https://datatables.net/examples/plug-ins/range_filtering.html
  							 -->  						
  								
							<table data-stripe-classes="[]" id="payments" class="table table-striped table-bordered" style="width:100%">
								<thead>
									<tr>
										<th></th>
										<th scope="col">Name</th>
										<th scope="col">Description</th>
										<th scope="col">Date</th>
										<th scope="col">Amount</th>
										<th scope="col">Currency</th>
										<th scope="col">Action</th>										
									</tr>
								</thead>	
								<tbody>									
									<c:forEach var="paymentIt" items="${payments}">
										<c:if test="${paymentIt.paid}">
											<tr class="paid">
											<c:set var = "paidTitle" scope = "session" value = "mark as unpaid"/>
											<c:set var = "paidClass" scope = "session" value = "fas fa-undo"/>
										</c:if>
										<c:if test="${not paymentIt.paid}">
											<tr class="unpaid">
											<c:set var = "paidTitle" scope = "session" value = "mark as paid"/>
											<c:set var = "paidClass" scope = "session" value = "far fa-check-circle"/>
										</c:if>
											<c:url var="editLink" value="/payment/updatePayment">
												<c:param name="paymentId" value="${paymentIt.id}" />
											</c:url>		
											<c:url var="removeLink" value="/payment/removePayment">
												<c:param name="paymentId" value="${paymentIt.id}" />
											</c:url>		
											<c:url var="markLink" value="/payment/markPayment">
												<c:param name="paymentId" value="${paymentIt.id}" />
											</c:url>		
														
											<td class=" details-control"></td>
											<td>${paymentIt.name}</td>
											<td>${paymentIt.description}</td>
											<td>${paymentIt.dateStr}</td>
											<td>${paymentIt.amount}</td>
											<td>${paymentIt.currency}</td>
											<td>
												<a href="${editLink}" class="deco-none"><i class="far fa-edit fa-md" id="icon_action" title="edit"></i></a><span style="display:inline-block; width: 10px;"></span>
												<a href="${removeLink}" class="deco-none"><i class="far fa-trash-alt fa-md" id="icon_action" title="delete"></i></a><span style="display:inline-block; width: 10px;"></span>
												<a href="${markLink}" class="deco-none"><i class="${paidClass} fa-md" id="icon_action" title="${paidTitle}"></i></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>							
							</table>
						</div>
					</div>
				</div>
			</div>
		</security:authorize>
	</div>
	
	<div id="base_url" style="display: none;">${pageContext.request.contextPath}</div>

</body>

</html>
