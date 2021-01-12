<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="styles/main.css">
    <script type="text/javascript" src="<c:url value="/scripts/validation.js"/>"></script>
</head>
<body>
<jsp:useBean id="today" class="java.util.Date" scope="request"/>
<jsp:useBean id="tomorrow" class="java.util.Date" scope="request"/>
<jsp:setProperty name="tomorrow" property="time" value="${tomorrow.time + 86400000}"/>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="all-content">
        <jsp:include page="main-topnav.jsp"/>
        <jsp:include page="main-content.jsp"/>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>