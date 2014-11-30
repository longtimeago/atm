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

<h3>Please upload a document</h3>
<form method="post" action="upload" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
<ppol:backButton/>
<ppol:exitButton/>
</body>
</html>