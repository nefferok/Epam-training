<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Registrate</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link rel="shortcut icon" type="image/ico" href="<c:url value="/images/favicon.ico"/>"/>
    <link rel="stylesheet" href="styles/forms.css">
    <script type="text/javascript" defer src="<c:url value="/scripts/cookie.js"/>"></script>
    <script type="text/javascript" defer src="<c:url value="/scripts/validation/registrate.js"/>"></script>
    <script type="text/javascript" defer src="<c:url value="/scripts/validation.js"/>"></script>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h2>Registrate account</h2>
        <c:if test="${not empty errMsg}">
            <div class="error" style="color:red">${errMsg}</div>
        </c:if>
        <form id="registrate" class="reg-form" name='registrate' action="<c:url value='/registrate'/>" method='POST'>
            <input type='text' id="userName" class="entry-field" name='userName' placeholder="Username" autofocus/>
            <input type='password' id="password" class="entry-field" name='password' placeholder="Password"/>
            <input type='password' class="entry-field" name='confirmPassword' id="confirmPassword"
                   placeholder="ConfirmPassword"/>
            <button type="submit" name="login-button" class="button">Registrate</button>
            <p class="message"><a href="login.jsp">LogIn</a></p>
            <p class="message"><a href="index.jsp">Home Page</a></p>
        </form>
    </div>
</div>
</body>
</html>
