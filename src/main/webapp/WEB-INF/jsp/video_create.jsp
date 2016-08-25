<%@ include file="include.jsp" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link rel="shortcut icon" href=
    <c:url value="${pageContext.request.contextPath}/resources/images/favicon.ico"/>/>
    <title>Element creation</title>
</head>
<body>

<form:form method="post" action="/element_create/Video" modelAttribute="video">
    <div class="container">
        <div class="column1 block">
            <p><label for="manuf">Manufacturer: </label></p>
            <p><label for="mem">Memory in Gb: </label></p>
            <p><input type="submit" style="width:100px" value="Save"/></p>
            <p><input type="button" style="width:100px" value="Back" onclick='location.href="/create_notebook"'/></p>
        </div>
        <div class="column2 block">
            <p><input id="manuf" name="manufacturer"/></p>
            <p><input id="mem" name="memoryInGb"/></p>
        </div>
    </div>

</form:form>
<div class="column3 block">
    <table>
        <th>Manufacturer</th>
        <th>Memory</th>
        <c:forEach items="${videos}" var="element">
            <tr>
                <td>${element.manufacturer}</td>
                <td>${element.memoryInGb}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>