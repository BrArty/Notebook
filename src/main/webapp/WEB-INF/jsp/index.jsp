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
<body bgcolor="#f0f8ff">

<form:form method="post" modelAttribute="notebook" action="/">
    <table align="center">
        <tr>
            <td><form:label path="id">Enter notebook id:</form:label></td>
            <td><form:input path="id" disabled="false"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Info"/></td>
        </tr>
        <tr>
            <td>
                <form>
                    <input type="button" value="Create new notebook" onclick='location.href="/create_notebook"'/>
                </form>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>