<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/18/2023
  Time: 11:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <label for="word">
        english
        <input type="text" name="word" id="word">
    </label>
    <button type="submit">Tra cứu</button>
</form>
<h2>Kết quả :</h2>
<p>${result}</p>
</body>
</html>
