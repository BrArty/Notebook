<%@ include file="include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href=<c:url value="${pageContext.request.contextPath}/resources/images/favicon.ico"/>/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
    <title>Stock</title>
</head>
<body>
<div class="container">
    <div class="column1 block">
        <form:form method="post" modelAttribute="item" action="/stock">
            <p>Add notebook to stock</p>
            <p><label for="note">Select notebook: </label></p>
            <p><form:select path="notebook.id" id="note">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${notebooks}" itemValue="id" itemLabel="info"/>
            </form:select></p>
            <p><label for="amount">Input amount: </label></p>
            <p><input placeholder="amount" name="amount" id="amount"/></p>
            <p><label for="price">Input price: </label></p>
            <p><input placeholder="price" name="price" id="price"/></p>
            <p><input type="submit" value="Add"/></p>
            <p><input type="button" class="button" value="Back" onclick='location.href="/"'/></p>
        </form:form>
    </div>
    <div class="column2 block">
        <p><label for="note">Select notebook you want to debit: </label></p>
        <form:form method="post" modelAttribute="debitItem" action="/stock/debit">
            <p><form:select path="id">
                <form:option disabled="true" value="0" label=""/>
                <form:options items="${list}" itemValue="id" itemLabel="notebook.info"/>
            </form:select></p>
            <p><label for="note">Input amount: </label></p>
            <p><input name="amount" id="amount" placeholder="amount"/></p>
            <p><input type="submit" value="Debit"/></p>
        </form:form>
    </div>
    <div class="column3 block">
        <table>
            <c:forEach items="${list}" var="element">
                <tr>
                    <td>${element.notebook.notebook_name} ${element.notebook.model}</td>
                    <td>${element.price}</td>
                    <td>${element.date}</td>
                    <td>${element.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
