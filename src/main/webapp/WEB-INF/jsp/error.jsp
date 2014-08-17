<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
</head>
<body>
    <h1>Error Page</h1>
    <p>Application has encountered an error. Please contact support</p>
    <!--
    Failed URL: ${url}
    Exception:  ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste}
    </c:forEach>
    -->
</body>
</html>
