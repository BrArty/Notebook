<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Notebook</title>
</head>
<body>

<form:form method="post" modelAttribute="notebook" action="/info">

    <tr>
        <td><form:label path="id">Enter notebook id:</form:label></td>
        <td><form:input path="id" disabled="false"/></td>
    </tr>

    <input type="submit" value="Show notebook">

</form:form>
<c:url var="toEdit" value="/edit/${notebook.id}"/>
<form:form method="get" action="${toEdit}">
    <input type="submit" value="Edit"/>
</form:form>
</body>
</html>