<%@ include file="include.jsp"%>
<html>
<head>
    <title>Creation</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/styles.css"/>"/>
</head>
<body>
<form:form modelAttribute="newNotebook" action="/create_notebook" method="post">
    <div class="container">
        <div class="column1 block">
            <p><label for="note">Notebook name: </label></p>
            <p><label for="screen">Set screen size: </label></p>
            <p><label for="hdd">Set hdd: </label></p>
            <p><label for="model">Set model: </label></p>
            <p><label for="proc">Set processor: </label></p>
            <p><label for="ram">Set ram: </label></p>
            <p><label for="video">Set video memory: </label></p>
            <input type="submit" class="button" value="Create"/>
            <form:form>
                <input type="button" class="button" value="Back" onclick='location.href="/"'/>
            </form:form>
        </div>
        <div class="column2 block">
            <input placeholder="Write here" name="notebook_name" id="note" class="for_input"/><br>
            <form:select path="screen.id" id="screen" cssClass="zero_space2">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${screens}" itemValue="id" itemLabel="size"/>
            </form:select><br>
            <form:select path="hdd.id" id="hdd" cssClass="zero_space2">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${hdds}" itemValue="id" itemLabel="memoryInGb"/>
            </form:select><br>
            <form:select path="model.id" id="model" cssClass="zero_space2">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${models}" itemValue="id" itemLabel="model"/>
            </form:select><br>
            <form:select path="processor.id" id="proc" cssClass="zero_space2">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${proces}" itemValue="id"/>
            </form:select><br>
            <form:select path="ram.id" id="ram" cssClass="zero_space2">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${rams}" itemValue="id" itemLabel="memoryInGb"/>
            </form:select><br>
            <form:select path="video.id" id="video" cssClass="zero_space2">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${videos}" itemValue="id"/>
            </form:select><br>
            <span style="color: red; font-style: italic;">${error}</span>
        </div>
        <div class="column3 block">
            <p>Create new element:</p>
            <form:form method="post" action="/element_create/Screen" cssClass="zero_space1">
                <input type="submit" value="New screen"/>
            </form:form>
            <form:form method="post" action="/element_create/Hdd" cssClass="zero_space1">
                <input type="submit" value="New hdd"/>
            </form:form>
            <form:form method="post" action="/element_create/Model" cssClass="zero_space1">
                <input type="submit" value="New model"/>
            </form:form>
            <form:form method="post" action="/element_create/Processor" cssClass="zero_space1">
                <input type="submit" value="New processor"/>
            </form:form>
            <form:form method="post" action="/element_create/Ram" cssClass="zero_space1">
                <input type="submit" value="New ram"/>
            </form:form>
            <form:form method="post" action="/element_create/Video" cssClass="zero_space1">
                <input type="submit" value="New video"/>
            </form:form>
        </div>
    </div>
</form:form>
</body>
</html>