<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Get quote. 
</h1>

<P>  The time on the server is ${serverTime}. </P>

<h2>Get a quote!</h2>
<form:form method="post" commandName="quoteRequest">
 
    <table>
    <tr>
        <td><form:label path="category">Category</form:label></td>
        <td><form:input path="category"  /></td> 
    </tr>
       <tr>
        <td><form:label path="ue.zip">zipcode</form:label></td>
        <td><form:input path="ue.zip" /></td> 
    </tr>
        <tr>
        <td><form:label path="detail">detail</form:label></td>
        <td><form:input path="detail" /></td> 
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
        <td colspan="2">
            <input type="submit" value="get quote"/>
        </td>
    </tr>
</table>  
     
</form:form>

</body>
</html>
