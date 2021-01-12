<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Index</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" type="image/ico" href="<c:url value="/images/favicon.ico"/>"/>
    <link rel="stylesheet" href="styles/index.css">
</head>
<body>
<div class="topnav">
    <c:if test="${empty userName}">
        <a href="registrate.jsp" class="button">Registrate</a>
        <a href="login.jsp" class="button">Login</a>
        <span>User : guest</span>
    </c:if>
    <c:if test="${not empty userName}">
        <form class="inline" method="post" action="<c:url value='/logout'/>">
            <button type="submit" class="button" name="submit_logout">
                LogOut
            </button>
        </form>
        <span>User : ${userName}</span>
    </c:if>
</div>
<div class="container">
    <div class="all-content">
        <c:if test="${not empty errMsg || not empty param.errMsg}">
            <div class="error">${errMsg}${param.errMsg}</div>
        </c:if>
        <h2>Training web project</h2>
        <p class="content-text">The app is a ToDo list with the ability to attach a file to each task in the list. The list contains three
            sections: Today, Tomorrow, and Someday. Each section can contain an unlimited number of tasks. If a task is
            added , it is automatically assigned a completion date. When you add a task to the Someday section, you are
            Prompted for the completion date. The Today section displays both today's tasks and overdue ones.</p>
        <p class="content-text"> All tasks added to the Tomorrow section are displayed in the Today section the day after they are added. You
            can
            mark tasks as completed, and then they disappear from the list and are shown in the Fixed section. You can
            delete tasks from any section and they end up in the trash . The task can be restored from the recycle
            bin.</p>
    </div>
</div>
<div class="footer">
    <p> © 2020 Copyright:
        <strong> Developed by Aliaksandr Litvinenka nefferok.litv1n@gmail.com &
            Siarhei Krautsou gooruken@gmail.com
        </strong>
    </p>
</div>
</body>
</html>