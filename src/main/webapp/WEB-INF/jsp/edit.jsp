<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit page</title>
    <style>
        select {
            width: 200px;
        }
    </style>
</head>
<body bgcolor="#f0f8ff">
<form:form modelAttribute="notebook" action="/edit?id=${notebook.id}" method="post">
    <table align="center">
        <tr>
            <td><label for="screen">Set screen size: </label></td>
            <td>
                <form:select path="screen.id" id="screen">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${screens}" itemValue="id" itemLabel="size"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label for="hdd">Set hdd: </label></td>
            <td>
                <form:select path="hdd.id" id="hdd">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${hdds}" itemValue="id" itemLabel="memoryInGb"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label for="model">Set model: </label></td>
            <td>
                <form:select path="model.id" id="model">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${models}" itemValue="id" itemLabel="model"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label for="proc">Set processor: </label></td>
            <td>
                <form:select path="processor.id" id="proc">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${proces}" itemValue="id"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label for="ram">Set ram: </label></td>
            <td>
                <form:select path="ram.id" id="ram">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${rams}" itemValue="id" itemLabel="memoryInGb"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><label for="video">Set video memory: </label></td>
            <td>
                <form:select path="video.id" id="video">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${videos}" itemValue="id"/>
                </form:select>
            </td>
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