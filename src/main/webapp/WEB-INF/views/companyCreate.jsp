<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring 3 MVC Series - Contact Manager</title>
</head>
<body>
<h2>Company sign up</h2>
<form:form method="post" commandName="company">
 
    <table>
    <tr>
        <td><form:label path="companyName">Company Name</form:label></td>
        <td><form:input path="companyName"  /></td> 
    </tr>
       <tr>
        <td><form:label path="userName">User Name</form:label></td>
        <td><form:input path="userName" /></td> 
    </tr>
        <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
        <tr>
        <td><form:label path="phone">Phone number</form:label></td>
        <td><form:input path="phone" /></td>
    </tr>
    <tr>
        <td><form:label path="category">Category</form:label></td>
        <td><form:input path="category" /></td>
    </tr>
        <tr>
        <td><form:label path="area">area</form:label></td>
        <td><form:input path="area" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="sign up"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>