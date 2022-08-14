<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isErrorPage="true" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Serene</title>
<link rel="stylesheet" href="/css/homE.css">
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
    
    <h2>Home Page</h2>
    <div class="box">
    	
    	<table class="table">
				
				<c:forEach var="post" items="${posts}">
				
					<tr>
						<td id="name"><a href="/post/${post.id}"><c:out value="${post.name}"/></a> - <c:out value="${post.about}"/></td>
						
					</tr>
					<tr>
						<td><c:out value="${post.quote }"></c:out>
					</tr>
				
				</c:forEach>
			
			</table>
			
    </div>
    <form:form action="/post/new">
		<input class="button" type="submit" value="New" />
	</form:form>
</body>
</html>