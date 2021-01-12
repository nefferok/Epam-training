<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Task</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="styles/main.css">
    <script type="text/javascript" src="<c:url value="/scripts/validation.js"/>"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="all-content">
        <p id="errorText" style="color:red"></p>
        <c:if test="${not empty errMsg}">
            <div class="error">${errMsg}</div>
        </c:if>
        <form class="newTask" name="newTask" method="post" action="<c:url value='/add'/>">
            <c:if test="${!empty param.added}">
                <strong style="color:darkolivegreen">Task added successfully</strong><br>
            </c:if>
            <input type="date" name="date" value="${param.curDate}">
            <input type="text" name="description" placeholder="Task description">
            <input type="hidden" name="view" value="${param.view}">
            <input type="hidden" name="curDate" value="${param.curDate}">
            <button type="submit" class="button" onclick="return validateAddTask()">Add Task</button>
            <button class="button" formmethod="get" formnovalidate
                    formaction="<c:url value="/main?view=${param.view}"/>">Back to Main
            </button>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
