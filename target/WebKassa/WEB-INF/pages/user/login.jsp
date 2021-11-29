<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 30.10.2021
  Time: 5:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Login page</title>
</head>
<body>
<c:url value="/login" var="var"/>
<form action="${var}" method="POST">

    <label for="login">Login   :</label>
    <input type="text" name="login" id="login">
    <br><br>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password">
    <br><br>
    <input type="submit" value="Log in">

</form>
</body>
</html>
