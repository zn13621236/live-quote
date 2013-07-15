<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Quote home page</title>
</head>
<body>
	<h1>Get quote.</h1>
	<table>
		<form:form method="post" commandName="quoteRequest">

			<tr>
				<td><form:label path="category">Category</form:label></td>
				<td><form:radiobutton path="category" value="roofing"
						label="roofing" /> <form:radiobutton path="category"
						value="cleaning" label="cleaning" /> <form:radiobutton
						path="category" value="plumbing" label="plumbing" /></td>
			</tr>

			<tr>
			<td>
			service time:
			</td>
			<td><form:input path="${day}" size="5" maxlength="2" value="day: 15" />/
				<form:input path="${month}" size="8" maxlength="2" value="month: 08"/>/
				<form:input path="${year}" size="8" maxlength="4" value="year: 2013"/></td>
			</tr>
			<tr>
				<td><form:label path="ue.zip">zipcode</form:label></td>
				<td><form:input path="ue.zip" /></td>
			</tr>

			<tr>
				<td><form:label path="ue.email">Email</form:label></td>
				<td><form:input path="ue.email" /></td>
			</tr>
			<tr>
				<td><form:label path="ue.cell">Phone number</form:label></td>
				<td><form:input path="ue.cell" /></td>
			</tr>
			<tr>
				<td><form:label path="detail">detail</form:label></td>
				<td><form:textarea path="detail" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="get quote" /></td>
			</tr>


		</form:form>

		<%-- 	<form:form method="post" commandName="serviceTime">
	
		</form:form> --%>
	</table>
</body>
</html>
