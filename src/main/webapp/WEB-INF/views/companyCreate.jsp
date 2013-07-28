<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Sign up</title>
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
<body>
	<h2>Company sign up</h2>
	<form:form method="post" commandName="company">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="companyName">Company Name</form:label></td>
				<td><form:input path="companyName" /></td>
				<td><form:errors path="companyName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="userName">User Name</form:label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="confirmPassword">Confirm password</form:label></td>
				<td><form:input path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td> 
				<td><form:errors path="email"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone number</form:label></td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td><form:label path="category">Category</form:label></td>
				<td><form:checkbox path="category" value="roofing"
						label="roofing" /> <form:checkbox path="category"
						value="cleaning" label="cleaning" /> <form:checkbox
						path="category" value="plumbing" label="plumbing" /></td>
			</tr>
			<tr>
				<td><form:label path="area">area</form:label></td>
				<td><form:checkbox path="area" value="seattle" label="seattle" />
					<form:checkbox path="area" value="portland" label="portland" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="sign up" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>