<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator
</h1>
<form method="post">
    <c:if test="${mess!=null}">
        <h3 style="color:red;">${mess}</h3>
    </c:if>
    <input type="number" name="operandFirst" required><br>
    <input type="number" name="operandSecond" required><br>
    <input type="submit" value="+" name="operator">
    <input type="submit" value="-" name="operator">
    <input type="submit" value="*" name="operator">
    <input type="submit" value="/" name="operator">
</form>
<c:if test="${result != null}">
   <h2 style="color: darkslategrey"> Result: ${result}</h2>
</c:if>
</body></body>
</html>