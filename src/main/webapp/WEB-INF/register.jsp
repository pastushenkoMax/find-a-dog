<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/register.css">
<meta charset="ISO-8859-1">
<title>Find a Dog</title>
</head>
<body>
<body>
	<div class=container>
		<div class=mainContainer>
			<div class=leftPicture>
				<img src="/images/registerImg1.jpg" alt="registerImg1.jpg">
			</div>
			<div class=mainContainerform>
				<form:form action="/register_user" method="post" modelAttribute="createUser">
					<p><form:errors path="userName" class="text-danger"></form:errors></p>
					<p><form:errors path="email" class="text-danger"></form:errors></p>
					<p><form:errors path="password" class="text-danger"></form:errors></p>
					<p><form:errors path="confirm" class="text-danger"></form:errors></p>
					<h1>Sign up a new account!</h1>
					<div class=forms>
					    <form:label path="userName" for="nameOfUser">Name: </form:label>
					    <form:input path="userName" type="text" class="form-control" id="user_Name" placeholder="Name" autocomplete="off"></form:input>
					</div>   
					<div class=forms> 
					    <form:label path="email" for="userEmail">Email: </form:label>
					    <form:input path="email" type="text" class="form-control" id="userEmail" placeholder="Email"></form:input>
					</div>   
					<div class=passwordForms>
						<div class="forms password"> 
							<form:label path="password" for="userPassword">Password: </form:label>
						    <form:input path="password" type="password" class="form-control" id="userPassword" placeholder="Password"></form:input>
						</div>   
						<div class="forms confirm"> 
							<form:label path="confirm" for="passwordConfirm">Confirm Password: </form:label>
						    <form:input path="confirm" type="password" class="form-control" id="userPassword" placeholder="Confirm Password"></form:input>
						</div>  
					</div> 
					<div class=submitBtn> 
						<input class="btn btn-primary" type="submit" value="Register">
					</div>
				</form:form>
			</div>
			<div class=rightPicture>
				<img src="/images/registerImg2.jpg" alt="registerImg2.jpg">
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
	</div>
</body>
</html>