<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Your Post</title>
<link rel="stylesheet" href="/css/neW.css">
</head>
<body>
	<nav class="navbar">
        <div class="logo">
            <a href="/home">
                <img alt="logo" src="/images/logo.png" class="primary-icon">
                
            </a><p class="title">Serene</p>
        </div>
        <ul class="nav-list">
            <li class="list-item">
                <a href="/home">Home</a>
            </li>
            <li class="list-item">
                <a href="/about">About</a>
            </li>
            <li class="list-item">
                <a href="/team">Team</a>
            </li>
            <li class="list-item">
                <a href="/logout">Log Out</a>
            </li>
        </ul>
    </nav>
    <h2>Edit Post</h2>
    <div class="box">
    	<form:form action="/post/${post.id}" method="post" modelAttribute="post">
			<div class="form">
				
				<form:label path="name">Name<span class="star">*</span></form:label>
				<form:errors path="name" class="error"/>
				<form:input class="data" path="name" type="text"/>
			</div>
			<div class="form">
				
				<form:label path="about">About<span class="star">*</span></form:label>
				<form:errors path="about" class="error"/>
				<form:input class="data" path="about" type="text"/>
			</div>
			<div class="form">
				
				<form:label path="quote">Quote<span class="star">*</span></form:label>
				<form:errors path="quote" class="error"/>
				<form:textarea path="quote" class="data"  rows="4"/>
			</div>
			<div class="form">
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}"/>
			</div>
			<div class="form">
				<input type="submit" value="Submit" class="button1"/>
			</div>
		</form:form>
		
   </div><a href="/home"><button class="button2">Cancel</button></a>
    <img src="/images/smiley.png" class="img">
    <form action="/post/${post.id}/delete" method="post" >
				<input type="submit" value="Delete" class="button3"/>
	</form>
</body>
</html>