<%@ include file="include.jsp" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/styles.css"/>"/>
    <title>Element creation</title>
</head>
<body>
<form:form method="post" action="/element_create/Model" modelAttribute="model">
    <div class="container">
        <div class="column1 block">
            <p><label for="type">Model: </label></p>
            <p><input type="submit" style="width:100px" value="Save"/></p>
            <p><input type="button" style="width:100px" value="Back" onclick='location.href="/create_notebook"'/></p>
        </div>
        <div class="column2 block">
            <p><input id="type" name="model"/></p>
        </div>
    </div>
</form:form>
</body>
</html>