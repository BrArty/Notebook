<%@ include file="include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link rel="shortcut icon" href=<c:url value="${pageContext.request.contextPath}/resources/images/favicon.ico" /> />
    <title>Info</title>
</head>
<body>
<form:form method="get" modelAttribute="notebook" action="/info?id=${notebook.id}">
    <div class="container">
        <div class="column1 block">
            <p>Notebook's id</p>
            <p>Notebook's name</p>
            <p>Model</p>
            <p>Hdd</p>
            <p>Processor</p>
            <p>Screen</p>
            <p>Ram</p>
            <p>Video memory</p>
            <p><input type="button" value="Edit" onclick='location.href="/edit?id=${notebook.id}"'/></p>
            <p><input type="button" value="Back" onclick='location.href="/"'/></p>
        </div>
        <div class="column2 block">
            <p>${notebook.id}</p>
            <p>${notebook.notebook_name}</p>
            <p>${notebook.model}</p>
            <p>${notebook.hdd}</p>
            <p>${notebook.processor}</p>
            <p>${notebook.screen}</p>
            <p>${notebook.ram}</p>
            <p>${notebook.video}</p>
        </div>
    </div>
</form:form>


</body>
</html>