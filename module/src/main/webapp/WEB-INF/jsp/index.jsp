<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Notebook</title>
</head>

<body>
<table>
    <tr>
        <td><span><strong>Notebook model: </strong></span></td>
    </tr>
    <tr>
        <td><c:out value="${notebook.model}"/></td>
    </tr>
    <tr>
        <td><c:out value="${notebook.processor}"/></td>
    </tr>
    <tr>
        <td><c:out value="${notebook.hdd}"/></td>
    </tr>
    <tr>
        <td><c:out value="${notebook.ram}"/></td>
    </tr>
    <tr>
        <td><c:out value="${notebook.screen}"/></td>
    </tr>
    <tr>
        <td><c:out value="${notebook.video}"/></td>
    </tr>


</table>
<c:url var="editUrl" value="/edit"/>
<form:form method="get" action="${editUrl}">
    <input type="submit" value="Edit notebook"/>
</form:form>


</body>
</html>