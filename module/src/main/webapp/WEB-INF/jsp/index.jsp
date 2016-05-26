<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Notebook</title>
</head>

<body>
<table>
    <tr>
        <td><span>Notebook model: </span></td>
        <td><c:out value="${notebook}"/></td>
    </tr>

</table>
<input type="submit" value="Edit profile"/>

</body>
</html>