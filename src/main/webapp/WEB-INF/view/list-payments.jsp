<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Payments</title>
</head>

<body>
	
	<h2>Payment Reminder Manager</h2>
	<p>
		User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
	</p>
	<p> 
		${username} - ${userId} 
		<security:authorize access="hasAnyRole('USER')">
		<div>user access</div>
		</security:authorize>
	</p>
	

</body>

</html>
