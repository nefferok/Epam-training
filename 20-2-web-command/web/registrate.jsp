<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrate</title>
    <script>
        function checkInput() {
            reg.login.value = reg.login.value.trim();
            if(reg.login.value === "") {
                document.getElementById("errMsg").innerHTML = "Login is empty";
                return false;
            }
            reg.password.value = reg.password.value.trim();
            if(reg.password.value === "") {
                document.getElementById("errMsg").innerHTML = "Password is empty";
                return false;
            }
            reg.mail.value = reg.mail.value.trim();
            if(reg.mail.value === "") {
                document.getElementById("errMsg").innerHTML = "Mail is empty";
                return false;
            }
            reg.submit();
        }
    </script>

</head>
<body>

<jsp:include page="header.jsp"/>

<p style="color: red;">${errorMessage}</p>

<form name="reg" action="<c:url value='/registration'/>" method="post" onsubmit="return false">
    <table>
        <tr>
            <td><i>Login:</i></td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td><i> Password:</i></td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><i> Mail:</i></td>
            <td><input type="text" name="mail"></td>
        </tr>
    </table><br>
    <p id="errMsg" style="color:red;"></p><br>
    <input type="submit" name="enter" value="Registration" onclick="return checkInput()"/><br><br>
</form>
<a href="index.jsp">Start menu</a>
<jsp:include page="footer.jsp"/>
</body>
</html>