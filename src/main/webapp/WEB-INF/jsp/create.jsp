<%@ include file="include.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creation</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/accordion.css"/>
    <link rel="shortcut icon" href=
            <c:url value="${pageContext.request.contextPath}/resources/images/favicon.ico"/>/>
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
        <div class="ac-container column3 block">
            <div>
                <input id="ac-1" name="accordion-1" type="radio"/>
                <label for="ac-1">New screen</label>
                <article class="ac-small">
                    <form:form method="post" action="/element_create/Screen" modelAttribute="screen">
                        <p><label class="exception" for="type1">Type here: </label>
                            <input class="exception" type="text" id="type1" name="size"/>
                            <input class="exception" type="submit" style="width:100px" value="Save"/></p>
                    </form:form>
                </article>
            </div>
            <div>
                <input id="ac-2" name="accordion-1" type="radio"/>
                <label for="ac-2">New hdd</label>
                <article class="ac-small">
                    <form:form method="post" action="/element_create/Hdd" modelAttribute="hdd">
                        <p><label class="exception" for="type2">Memory in Gb: </label>
                            <input class="exception" id="type2" name="memoryInGb"/>
                            <input class="exception" type="submit" style="width:100px" value="Save"/></p>
                    </form:form>
                </article>
            </div>
            <div>
                <input id="ac-3" name="accordion-1" type="radio"/>
                <label for="ac-3">New model</label>
                <article class="ac-small">
                    <form:form method="post" action="/element_create/Model" modelAttribute="model">
                        <p><label class="exception" for="type">Model: </label>
                            <input class="exception" id="type" name="model"/>
                            <input class="exception" type="submit" style="width:100px" value="Save"/></p>
                    </form:form>
                </article>
            </div>
            <div>
                <input id="ac-4" name="accordion-1" type="radio"/>
                <label for="ac-4">New processor</label>
                <article class="ac-medium">
                    <form:form method="post" action="/element_create/Processor" modelAttribute="processor">
                        <p><label class="exception" for="mod">Model: </label>
                            <input class="exception" id="mod" name="model"/>
                            <label class="exception" for="frq">Frequency: </label>
                            <input class="exception" id="frq" name="frequency"/>
                            <input class="exception" type="submit" style="width:100px" value="Save"/></p>
                    </form:form>
                </article>
            </div>
            <div>
                <input id="ac-5" name="accordion-1" type="radio"/>
                <label for="ac-5">New ram</label>
                <article class="ac-small">
                    <form:form method="post" action="/element_create/Ram" modelAttribute="ram">
                        <p><label class="exception" for="type3">Memory in Gb: </label>
                            <input class="exception" id="type3" name="memoryInGb"/>
                            <input class="exception" type="submit" style="width:100px" value="Save"/></p>
                    </form:form>
                </article>
            </div>
            <div>
                <input id="ac-6" name="accordion-1" type="radio"/>
                <label for="ac-6">New video</label>
                <article class="ac-medium">
                    <form:form method="post" action="/element_create/Video" modelAttribute="video">
                        <p><label class="exception" for="manuf">Manufacturer: </label>
                            <input class="exception" id="manuf" name="manufacturer"/>
                            <label class="exception" for="mem">Memory in Gb: </label>
                            <input class="exception" id="mem" name="memoryInGb"/>
                            <input class="exception" type="submit" style="width:100px" value="Save"/></p>
                    </form:form>
                </article>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>