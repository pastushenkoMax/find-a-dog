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
	<div class=ownerContainer>
		<h1><c:out value="${dog.user.userName}"></c:out> </h1>
		<h1><c:out value="${dog.dog_name}"></c:out> is your dog!</h1>
		<div class=btn>
			<div class="myBtn">
				<a href="/dog/${dog.id}/edit">Edit</a>
			</div>
			<div class="myBtn">
				<form action="/dog/delete/${dog.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input class="btnDelete" type="submit" value="Delete">
				</form>
			</div>
		</div>
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