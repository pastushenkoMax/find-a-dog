<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/login.css">
<meta charset="ISO-8859-1">
<title>Find a Dog</title>
</head>
<body>
	<div class=mainContainer>
		<div class=formContent>
			<div class=leftPicture>
				<img src="/images/loginImg1.jpg" alt="loginImg1.jpg">
			</div>
			<div class=midSection>
				<form:form action="/login_user" method="post" modelAttribute="createLogin">
					<h1>Sign in to account</h1>
					<p><form:errors path="email" class="text-danger"></form:errors></p>
					<p><form:errors path="password" class="text-danger"></form:errors></p>
					<div class=forms> 
						<form:label path="email" for="userEmail">Email: </form:label>
						<form:input path="email" type="text" class="form-control" id="userEmail" placeholder="User Email"></form:input>
					</div>   
					<div class=forms> 
						<form:label path="password" for="userPassword">Password: </form:label>
						<form:input path="password" type="password" class="form-control" id="userPassword" placeholder="User Password"></form:input>
					</div>   
					<div class=submitBtn> 
						<input class="btn btn-primary" type="submit" value="SIGN IN">
					</div>
				</form:form>
				<div>
					<p>Don't have an account? <a href="/new_user">Sign Up!</a></p>
				</div>
			</div>
			<div class=rightPicture>
				<img src="/images/loginImg2.jpg" alt="loginImg2.jpg">
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