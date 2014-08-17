<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="ppol" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <ppol:header/>
    <ppol:keypad/>
    <script type="text/javascript" src="/resources/js/login_keypad.js" ></script>

</head>
<body onload="">
<h2>Welcome to ATM</h2>
<form action="login" method="POST" id="login_form">
    Enter card number: <input id="keypad" type="text" name="card_number">
    <input type="submit" value="Submit" />
    <input type="reset" value="Clear" />
</form>
</body>
</html>