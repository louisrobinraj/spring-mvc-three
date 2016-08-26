<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" modelAttribute="loginBean" action="/spring-three-welcome/doLogin">
	<div align="center">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<div style="color: red">${error}</div>
	</div>
</form:form>