<%@ include file="include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <title>Notebook</title>
</head>
<body>
<form:form method="post" modelAttribute="notebook" action="/">
    <div class="container">
        <div class="column1 block">
            <p><label for="note">Select notebook: </label></p>
            <input type="button" value="Create new notebook" onclick='location.href="/create_notebook"'/>
            <input type="submit" value="Info"/>
        </div>
        <div class="column2 block">
            <form:select path="id" id="note">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${notebooks}" itemValue="id" itemLabel="notebook_name"/>
            </form:select><br>
            <p style="text-align: center; color: red; font-style: italic">${error}</p>
        </div>
    </div>
</form:form>
</body>
</html>