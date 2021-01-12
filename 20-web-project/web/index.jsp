<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="content">
    <div class="all-content">
        <c:if test="${not empty errMsg}">
            <div class="error">${errMsg}</div>
        </c:if>
        <h2 style="text-align: center">Training web project</h2>
        <p>The app is a ToDo list with the ability to attach a file to each task in the list. The list contains three
            sections: Today, Tomorrow, and Someday. Each section can contain an unlimited number of tasks. If a task is
            added , it is automatically assigned a completion date. When you add a task to the Someday section, you are
            Prompted for the completion date. The Today section displays both today's tasks and overdue ones.</p>
        <p> All tasks added to the Tomorrow section are displayed in the Today section the day after they are added. You
            can
            mark tasks as completed, and then they disappear from the list. and are shown in the Fixed section. You can
            delete tasks from any section and they end up in the trash . The task can be restored from the recycle
            bin.</p>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>