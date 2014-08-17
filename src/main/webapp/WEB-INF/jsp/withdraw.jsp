<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
</head>
<body>
<h2>Withdraw</h2>
<form action="withdraw" method="POST">
    Amount to withdraw: <input type="text" name="amount">
    <input type="submit" value="Submit" />
    <input type="reset" value="Clear" />
</form>
<ppol:backButton/>
<ppol:exitButton/>
</body>
</html>
