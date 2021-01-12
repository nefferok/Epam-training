<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrate</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="styles/forms.css">
    <script type="text/javascript" src="<c:url value="/scripts/validation.js"/>"></script>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h2>Registrate account</h2>
        <c:if test="${not empty errMsg}">
            <div class="error" style="color:red">${errMsg}</div>
        </c:if>
        <p id="errorText" style="color:red"></p>
        <form class="login-form" name='registrate' action="<c:url value='/registrate'/>" method='POST'>
            <input type='text' name='userName' placeholder="UserName"/>
            <input type='password' name='password' placeholder="Password"/>
            <input type='password' name='confPassword' placeholder="ConfirmPassword"/>
            <button type="submit" onclick="return validateRegistration()">Registrate</button>
            <p class="message"><a href="login.jsp">LogIn</a></p>
            <p class="message"><a href="index.jsp">Home Page</a></p>
        </form>
    </div>
</div>
</body>
</html>