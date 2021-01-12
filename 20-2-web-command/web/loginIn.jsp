<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <script>
        function checkInput() {
            log.login.value = log.login.value.trim();
            if(log.login.value === "") {
                document.getElementById("errMsg").innerHTML = "Login is empty";
                return false;
            }
            log.password.value = log.password.value.trim();
            if(log.password.value === "") {
                document.getElementById("errMsg").innerHTML = "Password is empty";
                return false;
            }
            log.submit();
        }
    </script>

</head>
<body>

<jsp:include page="header.jsp"/>

<p style="color: red;">${errorMessage}</p>

<form name="log" action="<c:url value='/login'/>" method="post" onsubmit="return false">
    <table>
        <tr>
            <td><i>Login:</i></td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td><i> Password:</i></td>
            <td><input type="text" name="password"></td>
        </tr>
    </table><br><br>
    <input type="submit" name="enter" value="Login In" onclick="return checkInput()"/><br>
    <p id="errMsg" style="color:red;"></p><br>
</form>
<a href="index.jsp">Start menu</a>
<jsp:include page="footer.jsp"/>
</body>
</html>