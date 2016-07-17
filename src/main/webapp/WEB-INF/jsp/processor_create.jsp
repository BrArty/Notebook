<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Element creation</title>
</head>
<body bgcolor="#f0f8ff">
<form:form method="post" action="/element_create/Processor" modelAttribute="processor">
    <table align="center">
        <tr>
            <td><label for="type1">Model: </label>
                <input id="type1" name="model"/></td>
        </tr>
        <tr>
            <td><label for="type2">Frequency: </label>
                <input id="type2" name="frequency"/></td>
            <td><input type="submit" value="Test"/></td>
        </tr>
        <tr>
            <td>
                <form:form>
                    <input type="button" value="Back" onclick='location.href="/"'/>
                </form:form>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>