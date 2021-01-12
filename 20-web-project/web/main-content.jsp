<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main-content">
    <c:if test="${not empty errMsg}">
        <div class="error">${errMsg}</div>
    </c:if>
    <strong>
        ${param.view}
        <c:if test="${param.view=='today'}">
            <fmt:formatDate type="date" value="${today}" pattern="dd.MM"/>
        </c:if>
        <c:if test="${param.view=='tomorrow'}">
            <fmt:formatDate type="date" value="${tomorrow}" pattern="dd.MM"/>
        </c:if>
    </strong>
    <form class="main-table" method="post" name="tasks" action="<c:url value='/operate'/>">
        <c:if test="${empty tasks}">
            <h2>No tasks</h2>
        </c:if>
        <c:if test="${!empty tasks}">
            <table class="tasks-table">
                <thead>
                <tr>
                    <th>Tasks</th>
                    <c:if test="${param.view=='someday' || param.view=='fixed' || param.view=='recycle' }">
                        <th>Date</th>
                    </c:if>
                </tr>
                </thead>
                <c:forEach var="task" items="${tasks}">
                    <c:set var="checkDate">
                        <fmt:formatDate pattern="yyyy-MM-dd" value="${today}"/>
                    </c:set>
                    <tr <c:if test="${checkDate gt task.date}">
                        style="color: red"
                    </c:if>>
                        <td style="width: 30px">
                            <input type="checkbox" name="idEvent" value="${task.id}"/>
                        </td>
                        <td>${task.bodyTask}</td>
                        <c:if test="${param.view=='someday' || param.view=='fixed' || param.view=='recycle' }">
                            <td>${task.date}</td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <jsp:include page="main-footnav.jsp"/>
    </form>
</div>
