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
<style>
    span.error {
        color: red;
    }
</style>
<body bgcolor="#f0f8ff">
<form:form method="post" modelAttribute="notebook" action="/">
    <table align="center">
        ${success}
        <tr>
            <td>
                <label id="note">Notebook's id: </label>
            </td>
            <td><form:select id="note" path="id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${allNotes}" var="notebook">
                    <form:option value="${notebook.id}" label="${notebook.notebook_name}, ${notebook.model}"/>
                </c:forEach>
            </form:select></td>
            <td>
                <span class="error"><form:errors path="id"/></span>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Info"/></td>
        </tr>
        <tr>
            <td>
                <form:form>
                    <input type="button" value="Create new notebook" onclick='location.href="/create_notebook"'/>
                </form:form>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>