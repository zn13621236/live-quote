<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>whatever</title>
</head>
<body>
	<h2>Company edit</h2>
	<form:form method="post" commandName="company2">
		<table border="1">
			<tr>
				<td>user name</td>
				<td><c:out value="${company.userName}"></c:out></td>
				<td><form:label path="userName">new username</form:label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>company password</td>
				<td><c:out value="****"></c:out></td>
				<td><form:label path="passWord">new password</form:label></td>
				<td><form:input path="passWord" /></td>
			</tr>
			<tr>
				<td>company phone</td>
				<td><c:out value="${company.phone}"></c:out></td>
				<td><form:label path="phone">new number</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
	
			<tr>
				<td colspan="2"><input type="submit" value="update" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>