<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>ERROR_EXCEPTION</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2><p style="color: red;"> RuntimeException during command execution</p></h2>
<p style="color: red;">
    Request from ${pageContext.errorData.requestURI} is failed
    <br/>
    Servlet name: ${pageContext.errorData.servletName}
    <br/>
    Status code: ${pageContext.errorData.statusCode}
    <br/>
    Exception: ${pageContext.exception}
    <br/>
    Message from exception: ${requestScope['javax.servlet.error.message']}
</p>
<jsp:include page="footer.jsp"/>
</body>
</html>