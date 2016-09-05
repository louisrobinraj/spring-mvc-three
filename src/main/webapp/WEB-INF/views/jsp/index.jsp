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
				type : "POST",
				url : "addData",
				data : JSON.stringify({
					userName : "Gerry",
					password : "Sydney"
				}),
				contentType : 'application/json',
				success : function(data) {
					alert(data);

				}
			});
		});
	});
</script>
</head>
<body>
	<a href="login">Login</a>
	<a href="singup">Sing Up</a>
	<button>Get Response Body</button>
</body>
</html>