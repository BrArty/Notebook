<%@ include file="include.jsp" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link rel="shortcut icon" href=<c:url value="${pageContext.request.contextPath}/resources/images/favicon.ico" /> />
    <title>Edit page</title>
</head>
<body>
<form:form modelAttribute="notebook" action="/edit?id=${notebook.id}" method="post">
    <div class="container">
        <div class="column1 block">
            <p><label for="screen">Set screen size: </label></p>
            <p><label for="hdd">Set hdd: </label></p>
            <p><label for="model">Set model: </label></p>
            <p><label for="proc">Set processor: </label></p>
            <p><label for="ram">Set ram: </label></p>
            <p><label for="video">Set video memory: </label></p>
            <p><input type="submit" value="Save changes"/></p>
            <p><input type="button" value="Back" onclick='location.href="/"'/></p>
        </div>
        <div class="column2 block">
            <form:select path="screen.id" id="screen" cssClass="zero_space2">
                <form:option disabled="true" value="0" label="Select__screen"/>
                <form:options items="${screens}" itemValue="id" itemLabel="size"/>
            </form:select><br>
            <form:select path="hdd.id" id="hdd" cssClass="zero_space2">
                <form:option disabled="true" value="0" label="Select__hdd"/>
                <form:options items="${hdds}" itemValue="id" itemLabel="memoryInGb"/>
            </form:select><br>
            <form:select path="model.id" id="model" cssClass="zero_space2">
                <form:option disabled="true" value="0" label="Select__model"/>
                <form:options items="${models}" itemValue="id" itemLabel="model"/>
            </form:select><br>
            <form:select path="processor.id" id="proc" cssClass="zero_space2">
                <form:option disabled="true" value="0" label="Select__processor"/>
                <form:options items="${proces}" itemValue="id"/>
            </form:select><br>
            <form:select path="ram.id" id="ram" cssClass="zero_space2">
                <form:option disabled="true" value="0" label="Select__ram"/>
                <form:options items="${rams}" itemValue="id" itemLabel="memoryInGb"/>
            </form:select><br>
            <form:select path="video.id" id="video" cssClass="zero_space2">
                <form:option disabled="true" value="0" label="Select__video"/>
                <form:options items="${videos}" itemValue="id"/>
            </form:select>
        </div>
    </div>
</form:form>
<div class="column3 block">
    <form:form method="post" action="/delete?id=${notebook.id}">
        <input type="submit" value="Delete"/>
    </form:form>
</div>
</body>
</html>