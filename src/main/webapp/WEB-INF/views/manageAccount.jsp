<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>company</title>
</head>
<body>
	<h2>manage account</h2>
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
		<tr>
			<td>start date</td>
			<td><c:out value="${company.addDate}"></c:out></td>
		</tr>
		<c:if test="${company.expireDate}!=null">
			<tr>
				<td>expire date</td>
				<td><c:out value="${company.expireDate}"></c:out></td>
			</tr>
		</c:if>


		<tr>
			<td>area</td>
		</tr>
		<c:forEach var="j" items="${company.area}">
			<tr>
				<td></td>
				<td><c:out value="${j}" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td>category</td>

		</tr>
		<c:forEach var="h" items="${company.category}">
			<tr>
				<td></td>
				<td><c:out value="${h}" /></td>

			</tr>
		</c:forEach>

		<tr>
			<td>email</td>

		</tr>
		<c:forEach var="i" items="${company.email}">
			<tr>
				<td></td>
				<td><c:out value="${i}" /></td>

			</tr>
		</c:forEach>
	</table>

<a href="<c:url value="/company/${company.guid}/update"/>">update</a>
</body>
</html>