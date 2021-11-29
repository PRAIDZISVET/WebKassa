<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 05/11/2021
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty workshift.id}">
        <title>Add workplace</title>
    </c:if>
    <c:if test="${!empty workshift.id}">
        <title>Edit workplace</title>
    </c:if>
</head>
<body>
<c:if test="${empty workshift.id}">
    <c:url value="/workshift/add" var="var"/>
</c:if>
<c:if test="${!empty workshift.id}">
    <c:url value="/workshift/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty workshift.id}">
        <label for="user_id">CashierID</label>
        <input type="text" name="user_id" id="user_id">
        <label for="workplace_id">WorkplaceID</label>
        <input type="text" name="workplace_id" id="workplace_id">
    </c:if>
    <c:if test="${!empty workshift.id}">
        <input type="hidden" name="id" value="${workshift.id}">
        <label for="user_id">CashierID</label>
        <input type="text" name="user_id" id="user_id" value="${workshift.user.id}">
        <label for="workplace_id">WorkplaceID</label>
        <input type="text" name="workplace_id" id="workplace_id" value="${workshift.workplace.id}">
    </c:if>
    <c:if test="${empty workshift.id}">
        <input type="submit" value="Add">
    </c:if>
    <c:if test="${!empty workshift.id}">
        <input type="submit" value="Edit">
    </c:if>
</form>
</body>
</html>
