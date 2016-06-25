<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit page</title>
</head>
<body bgcolor="#f0f8ff">

<form:form modelAttribute="notebook" action="/edit?id=${notebook.id}" method="post">
    <table border="1">
    </table>
    <table>
        <tr>
            <td>
                Set screen size:
            </td>
            <td><form:select path="screen.id">
                <form:option value="0" label="Select"/>
                <form:option value="1" label="15.6"/>
                <form:option value="2" label="17.0"/>
            </form:select></td>
        </tr>
    </table>

    <input type="submit" value="Confirm"/>

</form:form>

<form:form>
    <input type="button" value="Info" onclick='location.href="/info?id=${id}"'/>
</form:form>

</body>
</html>
