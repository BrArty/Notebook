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
<form:form method="post" action="/element_create/Video" modelAttribute="video">
    <table align="center">
        <tr>
            <td><label for="type1">Memory in Gb: </label></td>
            <td><input id="type1" name="manufacturer"/></td>
        </tr>
        <tr>
            <td><label for="type2">Manufacturer: </label></td>
            <td><input id="type2" name="memoryInGb"/></td>
        </tr>
        <tr>
            <td><input type="submit" style="width:100px" value="Confirm"/></td>
        </tr>
        <tr>
            <td>
                <form:form>
                    <input type="button" style="width:100px" value="Back" onclick='location.href="/create_notebook"'/>
                </form:form>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>