<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<c:if test="${empty login}">
    <table cellpadding="10">
        <tr>
            <td>User:</td>
            <td><b>guest</b></td>
            <td><a href="loginIn.jsp"> Login </a></td>
            <td><a href="registrate.jsp">Registrate</a></td>
        </tr>
    </table>
</c:if>
<c:if test="${not empty login}">
    <table cellpadding="5">
        <tr>
            <td>User:</td>
            <td><b>${login}</b></td>
            <td>
                <form action="<c:url value='/logout'/>" method="post">
                    <button type="submit" name="submit_logout">
                        LogOut
                    </button>
                </form>
            </td>
        </tr>
    </table>
</c:if>
<br>
<p/>
<hr>
</body>
</html>