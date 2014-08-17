<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
</head>
<body>

<form action="pin" method="POST">
    Enter pin: <input type="password" name="pin">
    <input type="submit" value="Submit" />
    <input type="reset" value="Clear" />
</form>

<ppol:backButton/>
<ppol:exitButton/>
</body>
</html>