<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
</div>
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

