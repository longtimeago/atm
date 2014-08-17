<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
    <ppol:keypad/>
    <script type="text/javascript" src="/resources/js/pin_keypad.js" ></script>
</head>
<body>

<form action="pin" method="POST">
    Enter pin: <input id="keypad" type="password" name="pin">
    <input type="submit" value="Submit" />
    <input type="reset" value="Clear" />
</form>

<ppol:backButton/>
<ppol:exitButton/>
</body>
</html>