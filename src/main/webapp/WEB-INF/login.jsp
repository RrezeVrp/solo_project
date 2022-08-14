<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="/css/registeR.css"/>
</head>
<body>
	<h2>Log In</h2>
	<div class="box">
			
			<form:form action="/login/new" method="post" modelAttribute="newLogin">
			
				
				<div class="form">
					<form:label path="email">Email<span class="star">*</span></form:label>
					<form:errors path="email" class="error"/>
					<form:input class="data" path="email" type="email"/>
				</div>
				
				<div class="form">
					<form:label path="password">Password<span class="star">*</span></form:label>
					<form:errors path="password" class="error"/>
					<form:input class="data" path="password" type="password"/>
				</div>
				
				<input class="button2" type="submit" value="Login" />
			
			</form:form>
		</div>
</body>
</html>