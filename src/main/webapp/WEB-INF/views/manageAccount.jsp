<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>company</title>
</head>
<body>
	<h2>manage email</h2>
	<table border="1">


		<tr>
			<td>company name</td>
			<td>${company.companyName}</td>
		</tr>
		<tr>
			<td>user name</td>
			<td>${company.userName}</td>
		</tr>
		<tr>
			<td>pass word</td>
			<td>${company.passWord}</td>
		</tr>
		<tr>
			<td>Account type</td>
			<td>${company.accountType}</td>
		</tr>
		<tr>
			<td>Account status</td>
			<td>${company.status}</td>
		</tr>
		<tr>
			<td>Phone number</td>
			<td>${company.phone}</td>
		</tr>

		<c:forEach var="j" items="${company.area}">
			<tr>
				<td><c:out value="${j}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/area/add"/>">add</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/area/remove"/>?oldArea=${j}">remove</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/area/update"/>?oldArea=${j}">update</a></td>
			</tr>
		</c:forEach>

		<c:forEach var="j" items="${company.category}">
			<tr>
				<td><c:out value="${h}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/category/add"/>">add</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/category/remove"/>?oldCategory=${h}">remove</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/category/update"/>?oldCategory=${h}">update</a></td>
			</tr>
		</c:forEach>

		<c:forEach var="i" items="${company.email}">
			<tr>
				<td><c:out value="${i}" /></td>
				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/add"/>">add</a></td>

				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/remove"/>?oldEmail=${i}">remove</a></td>
				<td><a
					href="<c:url value="/company/${company.guid}/emailManagement/update"/>?oldEmail=${i}">update</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>