<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<h1>Welcome, please login</h1>

	<form action="j_spring_security_check" id="login" method="post">
		<table>
			<tr>
			<td>
				<input type="text" id="username" name="username">
			</td>
			</tr>
			<tr>
			<td>
				<input type="password" id="password" name="password">
			</td>
			</tr>
			<tr>
			<td>
				<input type="submit" />
			</td>
			</tr>
		</table>
	</form>

</body>
</html>
