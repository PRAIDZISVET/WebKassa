<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 02.11.2021
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty currency.id}">
        <title>Add currency</title>
    </c:if>
    <c:if test="${!empty currency.id}">
        <title>Edit currency</title>
    </c:if>
</head>
<body>
<c:if test="${empty currency.id}">
    <c:url value="/currency/add" var="var"/>
</c:if>
<c:if test="${!empty currency.id}">
    <c:url value="/currency/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty currency.id}">
        <label for="code">Code</label>
        <input type="number" name="code" id="code">
        <label for="iso">ISO</label>
        <input type="text" name="iso" id="iso">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="active">isActive</label>
        <input type="text" name="active" id="active">
    </c:if>
    <c:if test="${!empty currency.id}">
        <input type="hidden" name="id" value="${currency.id}">
        <label for="code">Code</label>
        <input type="number" name="code" id="code" value="${currency.code}">
        <label for="iso">ISO</label>
        <input type="text" name="iso" id="iso" value="${currency.iso}">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${currency.name}">
        <label for="active">isActive</label>
        <input type="text" name="active" id="active" value="${currency.active}">
    </c:if>
    <c:if test="${empty currency.id}">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${!empty currency.id}">
        <input type="submit" value="Edit">
    </c:if>
</form>
</body>
</html>
