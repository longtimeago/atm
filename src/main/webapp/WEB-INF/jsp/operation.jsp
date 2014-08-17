<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
</head>
<body>
<h2>Available operations</h2>
<form action="balance" method="POST">
    <input type="submit" value="Balance" />
</form>
<form action="withdraw" method="GET">
    <input type="submit" value="Withdraw" />
</form>
<ppol:backButton/>
<ppol:exitButton/>
</body>
</html>