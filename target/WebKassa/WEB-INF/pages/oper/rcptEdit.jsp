<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 06.11.2021
  Time: 6:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty receipt.id}">
        <title>Add receipt</title>
    </c:if>
    <c:if test="${!empty receipt.id}">
        <title>Edit receipt</title>
    </c:if>
</head>
<body>
<c:if test="${empty receipt.id}">
    <c:url value="/receipt/add" var="var"/>
</c:if>
<c:if test="${!empty receipt.id}">
    <c:url value="/receipt/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty receipt.id}">
        <label for="oper_id">Oper</label>
        <input type="text" name="oper_id" id="oper_id">
        <label for="workshift_id">Workshift</label>
        <input type="text" name="workshift_id" id="workshift_id">
        <label for="rate_id">Rate</label>
        <input type="number" name="rate_id" id="rate_id">
        <label for="sumIn">SumIn</label>
        <input type="number" name="sumIn" id="sumIn">
        <label for="sumOut">SumOut</label>
        <input type="number" name="sumOut" id="sumOut">
    </c:if>
    <c:if test="${!empty receipt.id}">
        <input type="hidden" name="id" value="${receipt.id}">
        <label for="oper_id">Oper</label>
        <input type="text" name="oper_id" id="oper_id" value="${receipt.oper.id}">
        <label for="workshift_id">Workshift</label>
        <input type="text" name="workshift_id" id="workshift_id" value="${receipt.workshift.id}">
        <label for="rate_id">Rate</label>
        <input type="number" name="rate_id" id="rate_id" value="${receipt.rate.id}">
        <label for="sumIn">SumIn</label>
        <input type="number" name="sumIn" id="sumIn" value="${receipt.sumIn}">
        <label for="sumOut">SumOut</label>
        <input type="number" name="sumOut" id="sumOut" value="${receipt.sumOut}">
    </c:if>
    <c:if test="${empty receipt.id}">
        <input type="submit" value="Set new receipt">
    </c:if>
    <c:if test="${!empty receipt.id}">
        <input type="submit" value="Edit receipt">
    </c:if>
</form>
</body>
</html>
