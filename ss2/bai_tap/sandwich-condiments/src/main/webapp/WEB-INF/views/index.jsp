<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body{
            width: 700px;
            height: 700px;
            text-align: center;
        }
        form{
            width: 100%;
            height: 100%;
            margin: auto;

        }
        legend{
            text-align: center;
        }
        fieldset{
            border:5px outset lightsalmon;
        }
        label{
            display: inline-block;
            width: 100px;
            height: 25px;
        }
        input{
            display: inline-block;
            width: 20px;
            height: 20px;
        }
        legend{
            position: center;
        }
    </style>
</head>
<body class="container">
<form method="post">
    <fieldset>
        <legend class="center-pill"><h1>Sandwich Condiments</h1></legend>
        <label for="Lettuce"><input type="checkbox" value="Lettuce" name="condiment" id="Lettuce">Lettuce</label>
        <label for="Tomato"><input type="checkbox" value="Tomato" name="condiment" id="Tomato">Tomato</label>
        <label for="Mustard"><input type="checkbox" value="Mustard" name="condiment" id="Mustard">Mustard</label>
        <label for="Sprouts"><input type="checkbox" value="Sprouts" name="condiment" id="Sprouts">Sprouts</label>
        <hr style="color: darkslategrey">
        <button class="button" type="submit">Save</button>
    </fieldset>
</form>
<c:if test="${result!=null}">
    ${result}
</c:if>
</body>
</html>