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
                <form:option value="1" label="15.6"/>
                <form:option value="2" label="17.0"/>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="hdd.id">Hdd:</form:label></td>
            <td><form:select path="hdd.id">
                <form:option value="0" label="Select"/>
                <form:option value="1" label="500"/>
                <form:option value="2" label="750"/>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="model.id">Model:</form:label></td>
            <td><form:select path="model.id">
                <form:option value="0" label="Select"/>
                <form:option value="1" label="X540SA"/>
                <form:option value="2" label="Idea-Pad 100-15"/>
                <form:option value="3" label="Inspiron 3543"/>
                <form:option value="4" label="K55VM"/>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="processor.id">Processor:</form:label></td>
            <td><form:select path="processor.id">
                <form:option value="0" label="Select"/>
                <form:option value="1" label="Intel Pentium 3825U"/>
                <form:option value="2" label="Intel Core i5-3210M"/>
                <form:option value="3" label="Intel Pentium 3805U"/>
                <form:option value="4" label="Intel Celeron N3050"/>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="ram.id">Ram:</form:label></td>
            <td><form:select path="ram.id">
                <form:option value="0" label="Select"/>
                <form:option value="1" label="2"/>
                <form:option value="2" label="4"/>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="video.id">Video:</form:label></td>
            <td><form:select path="video.id">
                <form:option value="0" label="Select"/>
                <form:option value="1" label="Intel HD Graphics"/>
                <form:option value="2" label="nVidia GeForce GT 920M"/>
                <form:option value="3" label="nVidia GeForce 820M"/>
                <form:option value="4" label="NVIDIA GeForce GT 630M"/>
            </form:select></td>
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
