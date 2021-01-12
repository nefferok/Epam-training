<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start web</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<p style="color: red;">${errorMessage}</p>
<pre>
    <b>Web project</b>

    The application is a ToDo list with a file attached to each task of the list.
    The list should contain three sections: Today, Tomorrow and Someday. Each of
    the sections can contain an unlimited number of tasks.

    If a task is added to the Today or Tomorrow section, it is automatically
    assigned today's or tomorrow's due date. When adding a task to the Sometime
    section, you need to ask for a due date.
    In the Today section, both today's tasks and overdue ones. All tasks added to
    the Tomorrow section are the next day after those added to the Today section.
    Likewise, some tasks from the Someday section will form the new content of the
    Tomorrow section.

    Tasks can be marked as completed, after which they disappear from the list.
    However, they are not deleted physically, but are shown in the Fixed section.
    You can delete tasks from any section. As a result of this operation, they end
    up in the basket (another section). The task can be restored from the recycle
    bin. Then it is displayed in the section corresponding to the due date.
    You can empty it completely or delete the Trash one by one. In this case, the
    task is physically deleted.

    In order to enter the application, the user must register. Thus, the initial
    page of the application offers to register or authenticate. With the appropriate
    link (or) the user is shown either a registration form or a form for entering a
    username and password. After successful registration or authentication, the user
    is redirected to the page with his ToDo list.

    To simplify development, we will assume that the server and user times are the same.
</pre>
<jsp:include page="footer.jsp"/>
</body>
</html>