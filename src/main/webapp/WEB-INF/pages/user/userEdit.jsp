<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 30.10.2021
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.login}">
        <title>Add user</title>
    </c:if>
    <c:if test="${!empty user.login}">
        <title>Edit user</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.login}">
    <c:url value="/addUser" var="var"/>
</c:if>
<c:if test="${!empty user.login}">
    <c:url value="/editUser" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty user.login}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="login">Login</label>
        <input type="text" name="login" id="login">
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
        <label for="role_id">Role_id</label>
        <input type="text" name="role_id" id="role_id">
    </c:if>
    <c:if test="${!empty user.login}">
        <input type="hidden" name="id" value="${user.id}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${user.name}">
        <label for="login">Login</label>
        <input type="text" name="login" id="login" value="${user.login}">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" value="${user.password}">
        <label for="role_id">Role_id</label>
        <input type="text" name="role_id" id="role_id" value="${user.role.id}">
    </c:if>
    <c:if test="${empty user.login}">
        <input type="submit" value="Add new user">
    </c:if>
    <c:if test="${!empty user.login}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>
