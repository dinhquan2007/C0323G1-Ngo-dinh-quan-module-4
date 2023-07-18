<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Convert Cash</h1>
<br/>
<form action="/convert" method="post">
    <label for="usd">
        USD
        <input type="text" name="usd" id="usd">
    </label>
    <br/>
    <label for="rate">
        Rate
        <input type="text" name="rate" id="rate">
    </label>
    <br/>
    <button type="submit">Convert</button>
</form>
</body>
</html>