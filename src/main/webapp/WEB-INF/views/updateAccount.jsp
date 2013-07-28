<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>company</title>
</head>
<body>
	<h2>update account</h2>
	
	
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
				<td><form:label path="password">new password</form:label></td>
				<td><form:input path="password" /></td>
				<td><form:input path="confirmPassword" /></td>
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
	
	<table border="1">
		<tr>
			<td>area</td>
			<td><a href="<c:url value="/company/${company.guid}/area/add"/>">add</a></td>
		</tr>
		<c:forEach var="j" items="${company.area}">
			<tr>
				<td>Company area</td>

				<td><c:out value="${j}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/area/remove"/>?oldArea=${j}">remove</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/area/update"/>?oldArea=${j}">update</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td>category</td>
			<td><a
				href="<c:url value="/company/${company.guid}/category/add"/>">add</a></td>
		</tr>
		<c:forEach var="h" items="${company.category}">
			<tr>
				<td>Company category</td>
				<td><c:out value="${h}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/category/remove"/>?oldCategory=${h}">remove</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/category/update"/>?oldCategory=${h}">update</a></td>
			</tr>
		</c:forEach>

		<tr>
			<td>email</td>
			<td><a
				href="<c:url value="/company/${company.guid}/emailManagement/add"/>">add</a></td>
		</tr>
		<c:forEach var="i" items="${company.email}">
			<tr>
				<td>Company email list</td>
				<td><c:out value="${i}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/remove"/>?oldEmail=${i}">remove</a>
				</td>
				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/update"/>?oldEmail=${i}">update</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>