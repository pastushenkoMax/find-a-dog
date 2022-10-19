<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/description.css">
<title>Find a Dog</title>
</head>
<body>
	<div class=container>		
	<div class= dogContainer>
		<div class=showContainer>
			<h1><c:out value="${dog.dog_name}"></c:out></h1>
			<div class=dogImg>
				<img alt="img" src="/photos/<c:out value="${dog.photo.fileName}" />">
			</div>
			<div>
				<h2>Posted By: </h2>
				<h3><c:out value="${dog.user.userName}"></c:out></h3>
				<h2>Description: </h2>
				<h3><c:out value="${dog.dog_description}"></c:out></h3>
			</div>
		</div>			    
	<div class=emailContainer>
		<h1>You want to ask more?</h1>
		<h1>Send me Email!</h1>
		<form:form action="/sendEmail/${dog.id}" method="post" modelAttribute="createEmail">
			<div class="form">
	  			<p><form:errors path="fromName" class="text-danger"/></p>
			    <form:label path="fromName" for="fromName">First Name: </form:label>
			    <form:input path="fromName" type="text" class="form-control" id="fromName" placeholder="Your Name"/>
			</div>
			<div class="form">
	  			<p><form:errors path="fromEmail" class="text-danger"/></p>
			    <form:label path="fromEmail" for="fromEmail">Email: </form:label>
			    <form:input path="fromEmail" type="text" class="form-control" id="fromEmail" placeholder="Your Email"/>
			</div>
			<p><form:errors path="body" class="text-danger"/></p>
			<form:label path="body" for="body">Your Message: </form:label>
			<div class="form">
				<form:textarea path="body" id="body" rows="7" cols="25"/>
			</div>
			<div class="form">
				<form:input type="hidden" path="subject" value="${dog.dog_name}" class="form-control"/>				
				<form:input type="hidden" path="toEmail" value="${dog.user.email}" class="form-control"/>
			</div>
			
			<div class=submitBtn>
				<input class="btn btn-primary" type="submit" value="Submit">
			</div>
		</form:form>
	</div>
	</div>
</div>
	<div class=bottomContainer>
			<div>Follow us for more!</div>
			<div class=socialMediaIcons>
				<a href="https://www.facebook.com"><img src="/images/facebook_icon.png" alt="facebook_icon.png"></a>
				<a href="https://www.instagram.com"><img src="/images/instagram__icon.png" alt="instagram_icon.png"></a>
				<a href="https://twitter.com"><img src="/images/twitter_icon.png" alt="twitter_icon.png"></a>
				<a href="https://www.youtube.com"><img src="/images/youtube_icon.png" alt="youtube_icon.png"></a>	
			</div>
	</div>
</body>
</html>