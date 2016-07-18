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
    <table align="center">
        <tr>
            <td>
                Set screen size:
            </td>
            <td><form:select path="screen.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${screens}" var="screen">
                    <form:option value="${screen.id}" label="${screen}"/>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>
                Set hdd:
            </td>
            <td><form:select path="hdd.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${hdds}" var="hdd">
                    <form:option value="${hdd.id}" label="${hdd}"/>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>
                Set model:
            </td>
            <td><form:select path="model.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${models}" var="model">
                    <form:option value="${model.id}" label="${model}"/>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>
                Set processor:
            </td>
            <td><form:select path="processor.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${proces}" var="processor">
                    <form:option value="${processor.id}" label="${processor}"/>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>
                Set ram:
            </td>
            <td><form:select path="ram.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${rams}" var="ram">
                    <form:option value="${ram.id}" label="${ram}"/>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>
                Set video memory:
            </td>
            <td><form:select path="video.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${videos}" var="video">
                    <form:option value="${video.id}" label="${video}"/>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Confirm"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:form>
                    <input type="button" value="Info" onclick='location.href="/info?id=${notebook.id}"'/>
                </form:form>
            </td>
        </tr>
    </table>
</form:form>
<form:form method="post" action="/delete?id=${notebook.id}">
    <table align="center">
        <tr>
            <td><input type="submit" value="Delete"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>