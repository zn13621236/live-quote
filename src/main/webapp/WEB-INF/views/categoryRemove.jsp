<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>category</title>
</head>
<body>
	<h2>remove category</h2>
	<form method="post">
		<table border="1">
			<tr>
				<td>old category</td>
				<td>${oldCategory}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="remove" /></td>
			</tr>

		</table>
	</form>
</body>
</html>