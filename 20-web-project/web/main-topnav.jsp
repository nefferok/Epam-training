<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main-topnav">
    <form class="main-topnav-form" action="<c:url value='/main'/>">
        <c:forEach var="viewButton" items="${views}">
            <c:if test="${viewButton ne param.view}">
                <button type="submit" class="button" name="view" value="${viewButton}">${viewButton}
                    <c:if test="${viewButton == 'today'}">
                        <span>&nbsp<fmt:formatDate type="date" value="${today}" pattern="dd.MM"/></span>
                    </c:if>
                    <c:if test="${viewButton== 'tomorrow'}">
                        <span>&nbsp<fmt:formatDate type="date" value="${tomorrow}" pattern="dd.MM"/></span>
                    </c:if>
                    <c:if test="${viewButton == 'recycle'}">
                        <span>&nbspbyn</span>
                    </c:if>
                </button>
            </c:if>
        </c:forEach>
    </form>
</div>

