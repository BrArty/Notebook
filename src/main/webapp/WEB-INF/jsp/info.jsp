<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Info</title>
</head>
<body bgcolor="#f0f8ff">

<table align="center">
    <tr>
        <td>Notebook's id</td>
        <td>${notebook.id}</td>
    </tr>
    <tr>
        <td>Notebook's name</td>
        <td>${notebook.notebook_name}</td>
    </tr>
    <tr>
        <td>Model</td>
        <td>${notebook.model}</td>
    </tr>
    <tr>
        <td>Hdd</td>
        <td>${notebook.hdd}</td>
    </tr>
    <tr>
        <td>Processor</td>
        <td>${notebook.processor}</td>
    </tr>
    <tr>
        <td>Screen</td>
        <td>${notebook.screen}</td>
    </tr>
    <tr>
        <td>Ram</td>
        <td>${notebook.ram}</td>
    </tr>
    <tr>
        <td>Video memory</td>
        <td>${notebook.video}</td>
    </tr>
    <form:form>
        <tr>
            <td><input type="button" value="Edit" onclick='location.href="/edit?id=${notebook.id}"'/></td>
        </tr>
        <tr>
            <td><input type="button" value="Back" onclick='location.href="/"'/></td>
        </tr>
    </form:form>
</table>


</body>
</html>