<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Setting
</h1>
<br/>
<form:form modelAttribute="emailBox" action="edit" method="post">
    <table>
        <tr>
            <th>Languages :</th>
            <td><form:select path="language">
                <form:options items="${language}"/>
            </form:select></td>
        </tr>
        <tr>
            <th>Page Size :</th>
            <td>Show
                <form:select path="pageSize">
                    <form:options items="${pageSize}"/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th>Spams filter :</th>
            <td>
                <form:checkbox path="spamsFilter" value="${spamsFilter}"/>
                Enable spams filter
            </td>
        </tr>
        <tr>
            <th>Signature :</th>
            <td><form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <th></th>
            <td><form:button>update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>