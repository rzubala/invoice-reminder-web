<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>Payments list</title>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h2>Payment Reminder Manager</h2>
					</div>
					<!-- 
					<div class="panel-body">		
						User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
					</div>
					-->
				</div>
			</div>
		</div>
			

		<security:authorize access="hasAnyRole('USER')">
			<div class="row">
				<div class="col-md-6">	
					<div class="panel panel-info">
  						<div class="panel-heading"><h4>Payments for user: <b><security:authentication property="principal.username"/></b></h4></div>
		
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Name</th>
									<th scope="col">Description</th>
									<th scope="col">Date</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="paymentIt" items="${payments}">
									<tr>
										<td>${paymentIt.name}</td>
										<td>${paymentIt.description}</td>
										<td>${paymentIt.dateStr}</td>
										<td></td>
									</tr>
								</c:forEach>
							</tbody>
									
						</table>
					</div>
				</div>
			</div>
		</security:authorize>
	</div>

</body>

</html>
