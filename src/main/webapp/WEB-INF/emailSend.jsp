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
		<div class=emailSendContainer>
			<h2>Email Send to <c:out value="${dog.user.userName}"></c:out></h2>
			<div class=chSing>
				<img src="/images/CheckMark.png" alt="CheckMark.png">
				<h3>Thank You!</h3>
			</div>
			<div class="findAlldogs"><a href="/allDogs">Come Back!</a></div>
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