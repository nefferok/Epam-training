<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add task</title>
    <script>
        function checkInput() {
            add.task.value = add.task.value.trim();
            if (add.task.value === "") {
                document.getElementById("errMsg").innerHTML = "Task is empty";
                return false;
            }
            const date = add.date.value.trim()
            if (date === "") {
                document.getElementById("errMsg").innerHTML = "Date is empty";
                return false;
            }
            const d_arr = date.split('-');
            const d = new Date(d_arr[0] + '/' + d_arr[1] + '/' + d_arr[2] + '');
            if (d_arr[0] != d.getFullYear() || d_arr[1] != (d.getMonth() + 1) || d_arr[2] != d.getDate()) {
                document.getElementById("errMsg").innerHTML = "invalid date...";
                return false;
            }
            add.submit();
        }
    </script>
</head>
<body>
<jsp:include page="header.jsp"/>
<jsp:useBean id="today" class="java.util.Date" scope="request"/>
<jsp:useBean id="tomorrow" class="java.util.Date" scope="request"/>
<jsp:setProperty name="tomorrow" property="time" value="${tomorrow.time + 86400000}"/>
<p style="color: red;">${errorMessage}</p>
<form name="add" action="<c:url value='/add?nameTable=${param.nameTable}'/>" method="post">
    <table>
        <tr>
            <td><i>Task:</i></td>
            <td><input type="text" name="task"/></td>
        </tr>
        <tr>
            <td><i> Date:</i></td>
            <td><input type="date" name="date"
            <c:if test="${param.nameTable=='Today'}">
                       value="<fmt:formatDate type="date" value="${today}" pattern="yyyy-MM-dd"/>"
            </c:if>
            <c:if test="${param.nameTable=='Tomorrow'}">
                       value="<fmt:formatDate type="date" value="${tomorrow}" pattern="yyyy-MM-dd"/>"
            </c:if>
            ></td>
        </tr>
    </table>
    <br>
    <p id="errMsg" style="color:red;"></p><br>
    <input type="submit" name="enter" value="Add" onclick="return checkInput()"/><br>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>