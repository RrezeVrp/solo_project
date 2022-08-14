<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="/css/registeR.css"/>
</head>
<body>
	<h2>Sign up</h2>
	<div class="box">
			
			<form:form action="/register/new" method="post" modelAttribute="newUser">
			
				<div class="form">
					<form:label path="username">User Name<span class="star">*</span></form:label>
					<form:errors path="username" class="error"/>
					<form:input class="data" path="username" type="text" />
				</div>
				
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
				
				<div class="form">
					<form:label path="confirm">Confirm PW<span class="star">*</span></form:label>
					<form:errors path="confirm" class="error"/>
					<form:input class="data" path="confirm" type="password" />
				</div>
				
				<input class="button" type="submit" value="Register" />
				
			
			</form:form>
		</div>
</body>
</html>