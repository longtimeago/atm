<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
</head>
<body>
<h2>Withdraw report</h2>
<p>Transaction id: ${operation.id}</p>
<p>Amount: ${operation.amount}</p>
<ppol:backButton/>
<ppol:exitButton/>
</body>
</html>
