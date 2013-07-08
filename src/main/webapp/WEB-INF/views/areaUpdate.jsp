<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>update area</title>
</head>
<body>
	<h2>update area</h2>
	<form method="post" >
	<c:out value="${company.companyName}"></c:out>
	<table border="1">
		<tr>
			<td>old area</td>
			<td width=300><c:out value="${oldArea}"></c:out></td>
			        <td>new area</td>
        <td><input type="text" name="newArea" /></td> 
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