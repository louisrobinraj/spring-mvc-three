<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body bgcolor="#d5f5e3">
	<center>
		<h1>HR Management System</h1>

		<h2>Login Page</h2>
		${msg}
		<form:form method="post" modelAttribute="loginBean" action="doLogin">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" /></td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td  align="left"><input type="submit"value="Login" /></td>
					<td  align="left"><input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>