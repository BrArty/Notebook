<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit page</title>
</head>
<body>

<table>
    <form:form method="post" modelAttribute="modelName" action="/edit">
        <tr>
            <td><form:label path="model">Enter model:</form:label></td>
            <td><form:input path="model" disabled="false"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </form:form>
</table>

</body>
</html>
