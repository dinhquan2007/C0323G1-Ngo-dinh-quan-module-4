<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>List Setting Email Box</h1>
<table>
    <tr>
        <th>Language</th>
        <th>Page Size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>Update</th>

    </tr>
    <tr>
        <td>${emailBox.language}</td>
        <td>${emailBox.pageSize}</td>
        <td>${emailBox.spamsFilter}</td>
        <td>${emailBox.signature}</td>
        <td><a href="/edit">
            <button>update</button>
        </a></td>
    </tr>
</table>
</body>
</html>