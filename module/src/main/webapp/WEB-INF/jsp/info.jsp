<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Info</title>
</head>
<body>
<form:form method="post" modelAttribute="newNotebook" action="/info">

    <p>${newNotebook.notebook_name}</p>
    <p>${newNotebook.model}</p>
    <p>${newNotebook.processor}</p>
    <p>${newNotebook.screen}</p>
    <p>${newNotebook.ram}</p>
    <p>${newNotebook.video}</p>

    <tr>
        <td>Screens :</td>
        <td><form:select path="screen">
            <form:option value="0" label="select"/>
            <form:option value="1" label="15.6"/>
            <form:option value="2" label="17"/>
        </form:select></td>
    </tr>

</form:form>


<c:url value="/" var="goBack"/>
<form:form method="get" action="${goBack}">
    <input type="submit" value="Go back">
</form:form>

<c:url value="/edit/${newNotebook.id}" var="editNotebook"/>
<form:form method="get" action="${editNotebook}">
    <input type="submit" value="Edit">
</form:form>

</body>
</html>