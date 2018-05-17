<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html>

<head>
	
	<title>Login Page</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/sale-time.ico">
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" />

</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading" style="text-align: center;">
						<div style="font-size:30px;">Pay on time<img src="${pageContext.request.contextPath}/resources/img/sale-time.svg" width="40px" height="40px" style="margin-left: 10px;"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">		
			<div style="margin-top: 50px;" class="col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6">
				
				<div class="panel panel-info">
	
					<div class="panel-heading">
						<div class="panel-title">Sign In</div>
					</div>
	
					<div style="padding-top: 30px" class="panel-body">
	
						<!-- Login Form -->
						<form action="${pageContext.request.contextPath}/authenticateUser" method="POST" class="form-horizontal">
	
						    <!-- Place for messages: error, alert etc ... -->
						    <div class="form-group">
						        <div class="col-xs-15">
						            <div>
									
										<!-- Check for login error -->
									
										<c:if test="${param.error != null}">
											
											<div class="alert alert-danger col-xs-offset-1 col-xs-10">
												Invalid username and password.
											</div>
			
										</c:if>
											
										<!-- Check for logout -->
	
										<c:if test="${param.logout != null}">
											            
											<div class="alert alert-success col-xs-offset-1 col-xs-10">
												You have been logged out.
											</div>
									    
										</c:if>
										
						            </div>
						        </div>
						    </div>
	
							<!-- User name -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
								
								<input type="text" name="username" placeholder="username" class="form-control">
							</div>
	
							<!-- Password -->
							<div style="margin-bottom: 25px" class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span> 
								
								<input type="password" name="password" placeholder="password" class="form-control" >
							</div>
	
							<!-- Login/Submit Button -->
							<div style="margin-top: 10px" class="form-group">						
								<div class="col-sm-6 controls">
									<button type="submit" class="btn btn-success">Login</button>
								</div>
							</div>
	
							<input type="hidden"
								   name="${_csrf.parameterName}"
								   value="${_csrf.token}" />
	
						</form>
	
					</div>
					
				</div>
	
			</div>
		</div>
	</div>

   	<div class="container-fluid">
		<div id="address" class="col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6">
   			<span style="font-size: 16px;">Created by: </span><a href="mailto:rafal@zubala.com" style="font-size: 16px;">Rafał Zubala</a><br> 
			Visit me at: <a href="http://rafal.zubala.com">rafal.zubala.com</a>
		</div>
	</div>

    <footer id="footer">
    	<div class="container-fluid">
        	<p class="text-muted">
        		<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
        	</p>
     	</div>
    </footer>
    
</body>
</html>
