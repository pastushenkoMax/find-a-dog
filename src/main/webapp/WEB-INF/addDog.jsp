<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/addDog.css">
<meta charset="ISO-8859-1">
<title>Find a Dog</title>
</head>
<body>
	<div class=container>
		<div class=mainContainer>
			<div class=leftPicture>
				<img src="/images/addDogimg1.jpg" alt="addDogimg1.jpg">
			</div>
			<div class=mainContainerform>
				<form:form action="/newDog" enctype="multipart/form-data" method="post" modelAttribute="createDog">
					<h1>Add a new Dog!</h1>
					<div class=forms>
						<p><form:errors path="dog_name" class="text-danger"/></p>
						<form:label path="dog_name" for="dog_name">Dog Name: </form:label>
						<form:input path="dog_name" type="text" class="form-control" id="dog_name" placeholder="Dog Name"/>
					</div>  
					<div class=passwordForms> 
					<div class="forms password"> 
					    <form:label path="dog_description" for="description">Dog Description: </form:label>
					    <div>
					    	<p><form:errors path="dog_description" class="text-danger"/></p>
							<form:textarea path="dog_description" id="description" rows="7" cols="25"/>
					    </div>
					</div>    
    				<div class="form confirm"> 
					<form:label path="breed">Breed: </form:label>
				        <form:select path="breed">
					    	<c:forEach var="breed" items="${breeds}">
								<option value="${breed.id}">${breed.breed}</option>
							</c:forEach>
				        </form:select>
				       </div>
				       </div>
				       <div class=forms>
						<form:input type="hidden" path="user" value="${user_id}" class="form-control"/>
					</div>
				      <div class=submitBtn> 
				      	<label for="imageFile">Upload Photo: </label>
    					<input type="file" name="imageFile" id="imageFile" accept="image/png, image/jpeg"  value="choose"/>
    				</div>
					<div class=submitBtn> 
						<input class="btn btn-primary" type="submit" value="Add a dog!">
					</div>
				</form:form>
			</div>
			<div class=rightPicture>
				<img src="/images/addDogimg2.jpg" alt="addDogimg2.jpg">
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
</body>
</html>