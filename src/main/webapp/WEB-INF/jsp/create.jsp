<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Creation</title>
    <style>
        .button {
            width: 100px;
        }

        select {
            width: 200px;
        }

        h5 {
            color: red;
            text-align: center;
            padding-bottom: 0;
        }
    </style>
</head>
<body bgcolor="#f0f8ff">
<form:form modelAttribute="newNotebook" action="/create_notebook" method="post">
    <h5>${error}</h5>
    <table align="center">
        <tr>
            <td>Notebook name:</td>
            <td><input placeholder="Write here" name="notebook_name" style="width: 200px"/></td>
        </tr>
        <tr>
            <td><label for="screen">Set screen size: </label></td>
            <td>
                <form:select path="screen.id" id="screen">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${screens}" itemValue="id" itemLabel="size"/>
                </form:select>
            </td>
            <form:form>
                <td><input type="button" class="button"
                           value="New screen" onclick='location.href="/element_create/Screen"'/>
                </td>
            </form:form>
        </tr>
        <tr>
            <td><label for="hdd">Set hdd: </label></td>
            <td>
                <form:select path="hdd.id" id="hdd">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${hdds}" itemValue="id" itemLabel="memoryInGb"/>
                </form:select>
            </td>
            <form:form>
                <td><input type="button" class="button"
                           value="New hdd" onclick='location.href="/element_create/Hdd"'/></td>
            </form:form>
        </tr>
        <tr>
            <td><label for="model">Set model: </label></td>
            <td>
                <form:select path="model.id" id="model">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${models}" itemValue="id" itemLabel="model"/>
                </form:select>
            </td>
            <form:form>
                <td><input type="button" class="button"
                           value="New model" onclick='location.href="/element_create/Model"'/>
                </td>
            </form:form>
        </tr>
        <tr>
            <td><label for="proc">Set processor: </label></td>
            <td>
                <form:select path="processor.id" id="proc">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${proces}" itemValue="id"/>
                </form:select>
            </td>
            <form:form>
                <td><input type="button" class="button" value="New processor"
                           onclick='location.href="/element_create/Processor"'/></td>
            </form:form>
        </tr>
        <tr>
            <td><label for="ram">Set ram: </label></td>
            <td>
                <form:select path="ram.id" id="ram">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${rams}" itemValue="id" itemLabel="memoryInGb"/>
                </form:select>
            </td>
            <form:form>
                <td><input type="button" class="button"
                           value="New ram" onclick='location.href="/element_create/Ram"'/></td>
            </form:form>
        </tr>
        <tr>
            <td><label for="video">Set video memory: </label></td>
            <td>
                <form:select path="video.id" id="video">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${videos}" itemValue="id"/>
                </form:select>
            </td>
            <form:form>
                <td><input type="button" class="button"
                           value="New video" onclick='location.href="/element_create/Video"'/>
                </td>
            </form:form>
        </tr>
        <tr>
            <td>
                <input type="submit" class="button" value="Create"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:form>
                    <input type="button" class="button"
                           value="Back" onclick='location.href="/"'/>
                </form:form>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>