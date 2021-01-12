<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main-footnav">
    <strong id="errorText" style="color:red; align-content:center"></strong>
    <c:if test="${param.view=='today'}">
        <c:set var="curDate">
            <fmt:formatDate pattern="yyyy-MM-dd" value="${today}"/>
        </c:set>
    </c:if>
    <c:if test="${param.view=='tomorrow'}">
        <c:set var="curDate">
            <fmt:formatDate pattern="yyyy-MM-dd" value="${tomorrow}"/>
        </c:set>
    </c:if>
    <input type="hidden" name="view" value="${param.view}">
    <button formmethod="post" class="button" formaction="add.jsp?view=${param.view}&curDate=${curDate}">Add task
    </button>
    <c:if test="${!empty tasks}">
        <c:forEach var="but" items="${buttons}">
            <c:if test="${but=='Delete_All'}">
                <form class="main-footnav-form">
                    <c:forEach var="task" items="${tasks}">
                        <input type="hidden" name="idEvent" value="${task.id}"/>
                    </c:forEach>
                    <button type="submit" class="button" name="operation" value="Delete">Delete All</button>
                </form>
            </c:if>
            <c:if test="${but ne 'Delete_All'}">
                <button type="submit" class="button" name="operation" value="${but}"
                        onclick="return checkboxValidation()">${but}</button>
            </c:if>
        </c:forEach>
    </c:if>
</div>