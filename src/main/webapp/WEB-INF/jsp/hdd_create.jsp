<%@ include file="include.jsp" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <title>Element creation</title>
</head>
<body>
<form:form method="post" action="/element_create/Hdd" modelAttribute="hdd">
    <div class="container">
        <div class="column1 block">
            <p><label for="type">Memory in Gb: </label></p>
            <p><input type="submit" style="width:100px" value="Save"/></p>
            <p><input type="button" style="width:100px" value="Back" onclick='location.href="/create_notebook"'/></p>
        </div>
        <div class="column2 block">
            <p><input id="type" name="memoryInGb"/></p>
        </div>
    </div>
</form:form>
</body>
</html>