<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>LogIn</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" type="image/webp" href="<c:url value="/images/favicon.ico"/>"/>
    <link rel="stylesheet" href="styles/forms.css">
    <script type="text/javascript" defer src="<c:url value="/scripts/cookie.js"/>"></script>
    <script type="text/javascript" defer src="<c:url value="/scripts/validation/login.js"/>"></script>
    <script type="text/javascript" defer src="<c:url value="/scripts/validation.js"/>"></script>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h2>Login account </h2>
        <c:if test="${not empty errMsg}">
            <div class="error">${errMsg}</div>
        </c:if>
        <form id="login" class="login-form" name="login" action="<c:url value='/login'/>" method="POST">
            <input type="text" id="userName" class="entry-field" name="userName" placeholder="Username" autofocus/>
            <input type="password" id="password" class="entry-field" name="password" placeholder="Password"/>
            <button type="submit" class="button">login</button>
            <p class="message"><a href="registrate.jsp">Registrate Now</a></p>
            <p class="message"><a href="index.jsp">Home Page</a></p>
        </form>
    </div>
</div>
</body>
</html>