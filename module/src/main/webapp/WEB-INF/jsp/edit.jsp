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

    <form:form method="get" action="/edit/${notebook.id}">
        <%--<tr>
            <td><form:label path="id">Put notebook id:</form:label></td>
            <td><form:input path="id" disabled="false"/></td>
        </tr>--%>
        <p><c:out value="${notebook.id}"/></p>
        <p><c:out value="${notebook.notebook_name}"/></p>
        <p><c:out value="${notebook.model}"/></p>
    </form:form>
    <form:form method="post" action="/edit/${notebook.id}" modelAttribute="notebook">
        <tr>
            <td><form:label path="screen.id">Put id:</form:label></td>
            <td><form:input path="screen.id" disabled="false"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </form:form>

</table>
<c:url var="backURL" value="/"/>

<form:form method="get" action="${backURL}">
    <input type="submit" value="Back"/>
</form:form>

</body>
</html>
