<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>update category</title>
</head>
<body>
	<h2>update category</h2>
	<form method="post" >
	<c:out value="${company.companyName}"></c:out>
	<table border="1">
		<tr>
			<td>old category</td>
			<td width=300><c:out value="${oldCategory}"></c:out></td>
			        <td>new category</td>
        <td><input type="text" name="newCategory" /></td> 
		</tr>
		<tr>
        <td colspan="2">
            <input type="submit" value="update"/>
        </td>
    </tr>
		
	</table>
</form>
</body>
</html>