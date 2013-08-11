<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>email</title>
</head>
<body>
	<h2>add email</h2>
	<form method="post" >
	<c:out value="${company.companyName}"></c:out>
	<table border="1">
		<tr>
			        <td>new email</td>
        <td><input type="text" name="newEmail" /></td> 
		</tr>
		<tr>
        <td colspan="2">
            <input type="submit" value="add"/>
        </td>
    </tr>
		
	</table>
</form>
</body>
</html>