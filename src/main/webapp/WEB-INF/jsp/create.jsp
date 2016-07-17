<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Creation</title>
</head>
<body bgcolor="#f0f8ff">

<form:form modelAttribute="newNotebook" action="/create_notebook" method="post">
    <table align="center">
        <tr>
            <td><form:label path="notebook_name">Notebook name:</form:label></td>
            <td><form:input path="notebook_name"/></td>
        </tr>
        <tr>
            <td><form:label path="screen.id">Screen:</form:label></td>
            <td><form:select path="screen.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${screens}" var="screen">
                    <form:option value="${screen.id}" label="${screen}"/>
                </c:forEach>
            </form:select></td>
            <form:form>
                <td><input type="button" value="New screen" onclick='location.href="/element_create/Screen"'/>
                </td>
            </form:form>
        </tr>
        <tr>
            <td><form:label path="hdd.id">Hdd:</form:label></td>
            <td><form:select path="hdd.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${hdds}" var="hdd">
                    <form:option value="${hdd.id}" label="${hdd}"/>
                </c:forEach>
            </form:select></td>
            <form:form>
                <td><input type="button" value="New hdd" onclick='location.href="/element_create/Hdd"'/></td>
            </form:form>
        </tr>
        <tr>
            <td><form:label path="model.id">Model:</form:label></td>
            <td><form:select path="model.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${models}" var="model">
                    <form:option value="${model.id}" label="${model}"/>
                </c:forEach>
            </form:select></td>
            <form:form>
                <td><input type="button" value="New model" onclick='location.href="/element_create/Model"'/>
                </td>
            </form:form>
        </tr>
        <tr>
            <td><form:label path="processor.id">Processor:</form:label></td>
            <td><form:select path="processor.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${proces}" var="processor">
                    <form:option value="${processor.id}" label="${processor}"/>
                </c:forEach>
            </form:select></td>
            <form:form>
                <td><input type="button" value="New processor"
                           onclick='location.href="/element_create/Processor"'/></td>
            </form:form>
        </tr>
        <tr>
            <td><form:label path="ram.id">Ram:</form:label></td>
            <td><form:select path="ram.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${rams}" var="ram">
                    <form:option value="${ram.id}" label="${ram}"/>
                </c:forEach>
            </form:select></td>
            <form:form>
                <td><input type="button" value="New ram" onclick='location.href="/element_create/Ram"'/></td>
            </form:form>
        </tr>
        <tr>
            <td><form:label path="video.id">Video:</form:label></td>
            <td><form:select path="video.id">
                <form:option value="0" label="Select"/>
                <c:forEach items="${videos}" var="video">
                    <form:option value="${video.id}" label="${video}"/>
                </c:forEach>
            </form:select></td>
            <form:form>
                <td><input type="button" value="New video" onclick='location.href="/element_create/Video"'/>
                </td>
            </form:form>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create"/>
            </td>
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
