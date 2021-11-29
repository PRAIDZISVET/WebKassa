<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 04.11.2021
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty rate.id}">
        <title>Add rate</title>
    </c:if>
    <c:if test="${!empty rate.id}">
        <title>Edit rate</title>
    </c:if>
</head>
<body>
<c:if test="${empty rate.id}">
    <c:url value="/rate/add" var="var"/>
</c:if>
<c:if test="${!empty rate.id}">
    <c:url value="/rate/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty rate.id}">
        <label for="currin_id">CurrIn</label>
        <input type="text" name="currin_id" id="currin_id">
        <label for="currout_id">CurrOut</label>
        <input type="text" name="currout_id" id="currout_id">
        <label for="value">Value</label>
        <input type="number" step=any name="value" id="value">
 <%--          <label for="setdatetime">SetDateTime</label>
                <input type="datetime-local" name="setdatetime" id="setdatetime">
--%>
            </c:if>
            <c:if test="${!empty rate.id}">
                <input type="hidden" name="id" value="${rate.id}">
                <label for="currin_id">CurrIn</label>
                <input type="text" name="currin_id" id="currin_id" value="${rate.currIn.id}">
                <label for="currout_id">CurrOut</label>
                <input type="text" name="currout_id" id="currout_id" value="${rate.currOut.id}">
                <label for="value">Value</label>
                <input type="number" step=any name="value" id="value" value="${rate.value}">
<%--                <label for="setdatetime">SetDateTime</label>
                <input type="datetime-local" name="setdatetime" id="setdatetime" value="${rate.setDateTime}">
--%>
            </c:if>
            <c:if test="${empty rate.id}">
                <input type="submit" value="Set">
            </c:if>
            <c:if test="${!empty rate.id}">
                <input type="submit" value="Edit">
            </c:if>
        </form>
        </body>
        </html>
