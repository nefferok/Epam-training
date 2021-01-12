<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Main task</title>
    <script>
        function checkInput() {
            let checkBox = document.getElementsByName("idTask");
            let checked = false;
            for (let i = 0; i < checkBox.length; i++) {
                if (checkBox[i].checked) {
                    checked = true;
                    break;
                }
            }
            if (!checked) {
                document.getElementById("errMsg").innerHTML = "No checked tasks";
                return false;
            }
            tasks.submit();
        }

    </script>
</head>
<body>
<jsp:include page="header.jsp"/>

<jsp:useBean id="today" class="java.util.Date" scope="request"/>
<jsp:useBean id="tomorrow" class="java.util.Date" scope="request"/>
<jsp:setProperty name="tomorrow" property="time" value="${tomorrow.time + 86400000}"/>

<p style="color: red;">${errorMessage}</p>

<table border=0>
    <tr>
        <c:forEach var="table" items="${namesTable}">
            <td><a href='<c:url value="/main?nameTable=${table}"/>'>${table}</a></td>
        </c:forEach>
    </tr>
</table>
<h2>${nameTable}
    <c:if test="${nameTable=='Today'}">
        <fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>
    </c:if>
    <c:if test="${nameTable=='Tomorrow'}">
        <fmt:formatDate type="date" value="${tomorrow}" pattern="yyyy-MM-dd"/>
    </c:if>
</h2>
<p/>
<c:if test="${empty list}">
    <p style="color:green;">
        Add the first task and get started...
    </p>
</c:if>
<c:if test="${not empty list}">
    <form id="tasks" action="<c:url value='/operations'/>" method="post">
        <table border=0>
            <thead>
            <th></th>
            <th>Task</th>
            <c:if test="${nameTable=='Someday' || nameTable=='Fixed' || nameTable=='Recycle' }">
                <th>Date</th>
            </c:if>
            </thead>
            <tbody>
            <c:forEach var="task" items="${list}">
                <tr>
                    <td><input type=checkbox name=idTask value="${task.id}"/></td>
                    <td>${task.task}</td>
                    <c:if test="${nameTable=='Someday' || nameTable=='Fixed' || nameTable=='Recycle' }">
                        <td>${task.date}</td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <p/>
        <p id="errMsg" style="color:red;"></p>
        <input type="hidden" name="command" value="Operations">
        <input type="hidden" name="nameTable" value="${nameTable}">

        <c:forEach var="button" items="${buttons}">
            <button type="submit" name="button" value="${button}" onclick="return checkInput()">${button}</button>
        </c:forEach>

    </form>
</c:if>
<p/>
<c:if test="${nameTable=='Today' || nameTable=='Tomorrow' || nameTable=='Someday' }">
    <form id="tasks" action="<c:url value='/addTask.jsp'/>" method="post">
        <input type="hidden" name="nameTable" value="${nameTable}">
        <input type="submit" value="Add task">
    </form>
</c:if>
<jsp:include page="footer.jsp"/>
</body>
</html>