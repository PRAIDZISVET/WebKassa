<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 02/11/2021
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty workplace.id}">
        <title>Add workplace</title>
    </c:if>
    <c:if test="${!empty workplace.id}">
        <title>Edit workplace</title>
    </c:if>
</head>
<body>
<c:if test="${empty workplace.id}">
    <c:url value="/workplace/add" var="var"/>
</c:if>
<c:if test="${!empty workplace.id}">
    <c:url value="/workplace/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty workplace.id}">
        <label for="code">Code</label>
        <input type="text" name="code" id="code">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="address">Address</label>
        <input type="text" name="address" id="address">
            </c:if>
    <c:if test="${!empty workplace.id}">
        <input type="hidden" name="id" value="${workplace.id}">
        <label for="code">Code</label>
        <input type="text" name="code" id="code" value="${workplace.code}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${workplace.name}">
        <label for="address">Address</label>
        <input type="text" name="address" id="address" value="${workplace.address}">
    </c:if>
    <c:if test="${empty workplace.id}">
        <input type="submit" value="Add new workplace">
    </c:if>
    <c:if test="${!empty workplace.id}">
        <input type="submit" value="Edit workplace">
    </c:if>
</form>
</body>
</html>