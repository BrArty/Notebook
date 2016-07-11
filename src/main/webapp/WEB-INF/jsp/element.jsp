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
<form:form method="post" action="/element_create?element=Screen" modelAttribute="screen">
    <table align="center">
        <tr>
            <td><label for="type">Type here: </label>
                <input id="type" name="size"/></td>
            <td><input type="submit" value="Test"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
