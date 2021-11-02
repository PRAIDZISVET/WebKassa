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
    <title>Login page</title>
</head>
<body>
<c:url value="/login" var="var"/>
<form action="${var}" method="POST">

    <label for="login">Login</label>
    <input type="text" name="login" id="login">
    <label for="password">Password</label>
    <input type="password" name="password" id="password">
    <input type="submit" value="Log in">


    <h2><a href="/admin">admin page</a></h2>
    <h2><a href="/cashier">cashier page</a></h2>
</body>
</html>
