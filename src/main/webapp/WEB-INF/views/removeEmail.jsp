<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>email</title>
</head>
<body>
	<h2>remove email</h2>
	<form method="post">
		<table border="1">
			<tr>
				<td>old email</td>
				<td>${oldEmail}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="remove" /></td>
			</tr>

		</table>
	</form>
</body>
</html>