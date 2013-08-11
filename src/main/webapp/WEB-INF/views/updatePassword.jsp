<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Change password</title>
</head>
<body>
	<h2>Change password</h2>
	<form:form method="post" commandName="changePassForm">
		<table>
		<tr>
				<td><form:label path="oldPassWord">Old Password</form:label></td>
				<td><form:input type="password" path="oldPassWord" /></td>
				<td><form:errors path="oldPassWord"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="newPassWord">New Password</form:label></td>
				<td><form:input type="password" path="newPassWord" /></td>
				<td><form:errors path="newPassWord"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="confirmPassword">Confirm password</form:label></td>
				<td><form:input type="password" path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="update" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>