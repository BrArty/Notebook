<%--suppress ALL --%>
<%@ include file="include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <link rel="shortcut icon" href=<c:url value="${pageContext.request.contextPath}/resources/images/favicon.ico" /> />
    <title>Notebook</title>
</head>
<body>
    <form:form method="post" modelAttribute="notebook" action="/">
        <div class="container">
            <div class="column1 block">
                <table>
                    <th>Notebook</th>
                    <th>Model</th>
                    <th>Screen</th>
                    <th>Ram</th>
                    <th>Hdd</th>
                    <th>Processor</th>
                    <th>Videomemory</th>
                    <c:forEach items="${notebooks}" var="element">
                        <tr>
                            <td>${element.notebook_name}</td>
                            <td>${element.model.model}</td>
                            <td>${element.screen.size}</td>
                            <td>${element.ram.memoryInGb}</td>
                            <td>${element.hdd.memoryInGb}</td>
                            <td>${element.processor.model}, ${element.processor.frequency}</td>
                            <td>${element.video.manufacturer}, ${element.video.memoryInGb}</td>
                            <td><a href="/edit?id=${element.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="column2 block">
                <input type="button" value="Create new notebook" onclick='location.href="/create_notebook"'/>
                <input type="button" value="Warehouse" onclick='location.href="/stock"'/>
            </div>
        </div>
    </form:form>
</body>
</html>