<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Menu Page</title>
<script>
	$(document).ready(function() {
		$("button").click(function() {
			var json = {
				"name" : "jenis",
				"message" : "model"
				
			};

			
			
			
			$.ajax({
				  type: "post",
					url : "http://localhost:9080/spring-mvc-three/save/save-user",
				  cache: false,    
				  data:json,
				  success: function(response){
				   $('#result').html("");
				   var obj = JSON.parse(response);
				   $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
				  },
				  error: function(){      
				   alert('Error while request..');
				  }
			 });
		
		});
	});
</script>
</head>
<body>
	<a href="login">Login</a>
	<a href="singup">Sing Up</a>
	<button>Get External Content</button>
</body>
</html>