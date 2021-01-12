<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>LogIn</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="styles/forms.css">
    <script type="text/javascript" src="<c:url value="/scripts/validation.js"/>"></script>
</head>
<div class="login-page">
    <div class="form">
        <h2>Login account </h2>
        <c:if test="${not empty errMsg}">
            <div class="error" style="color:red">${errMsg}</div>
        </c:if>
        <p id="errorText" style="color:red"></p>
        <form class="login-form" name='login' action="<c:url value='/login'/>" method='POST'>
            <input type='text' name='userName' placeholder="UserName"/>
            <input type='password' name='password' placeholder="Password"/>
            <button type="submit" onclick="return validateLogin()">
            login</button>
            <p class="message"><a href="registrate.jsp">Registrate Now</a></p>
            <p class="message"><a href="index.jsp">Home Page</a></p>
        </form>
    </div>
</div>
</html>