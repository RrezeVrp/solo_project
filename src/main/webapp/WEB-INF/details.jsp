<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isErrorPage="true" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Details </title>
<link rel="stylesheet" href="/css/detailS.css"/>
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
    <h1><c:out value="${post.name}"/></h1>
    <div class="box">
	
		
		<h3>Posted by: <c:out value="${post.user.username }"></c:out></h3>
		<table class="table">
			<tr>
				<td>About: <c:out value="${post.about}"/></td>
			</tr>
			<tr>
				<td><c:out value="${post.quote}"/></td>
			</tr>
		</table>
		
		<c:if test = "${post.user.id==user.id}">
			       <a href="/post/${post.id}/edit" class="button"><button>Edit</button> </a>
		</c:if>
		
	</div>
</body>
</html>