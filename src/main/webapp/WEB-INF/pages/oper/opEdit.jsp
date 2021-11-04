<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 03/11/2021
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty oper.id}">
        <title>Add oper</title>
    </c:if>
    <c:if test="${!empty oper.id}">
        <title>Edit oper</title>
    </c:if>
</head>
<body>
<c:if test="${empty oper.id}">
    <c:url value="/oper/add" var="var"/>
</c:if>
<c:if test="${!empty oper.id}">
    <c:url value="/oper/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty oper.id}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="active">isActive</label>
        <input type="text" name="active" id="active">
    </c:if>
    <c:if test="${!empty oper.id}">
        <input type="hidden" name="id" value="${oper.id}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${oper.name}">
        <label for="active">isActive</label>
        <input type="text" name="active" id="active" value="${oper.active}">
    </c:if>
    <c:if test="${empty oper.id}">
        <input type="submit" value="Add new oper">
    </c:if>
    <c:if test="${!empty oper.id}">
        <input type="submit" value="Edit oper">
    </c:if>
</form>
</body>
</html>
