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
				<td><form:errors path="category"></form:errors></td>
			</tr>

			<tr>
				<td>service time:</td>
				<td><form:input path="serviceTime" placeholder="MM/DD/YYYY" /></td>
				<td><form:errors path="serviceTime"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="ue.zip">zipcode</form:label></td>
				<td><form:input path="ue.zip" /></td>
				<td><form:errors path="ue.zip"></form:errors></td>
			</tr>

			<tr>
				<td><form:label path="ue.email">Email</form:label></td>
				<td><form:input path="ue.email" /></td>
				<td><form:errors path="ue.email"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="ue.cell">Phone number</form:label></td>
				<td><form:input path="ue.cell" /></td>
				<td><form:errors path="ue.cell"></form:errors></td>
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
