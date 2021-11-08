<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 05/11/2021
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty rest.id}">
        <title>Add rest</title>
    </c:if>
    <c:if test="${!empty rest.id}">
        <title>Edit rest</title>
    </c:if>
</head>
<body>
<c:if test="${empty rest.id}">
    <c:url value="/rest/add" var="var"/>
</c:if>
<c:if test="${!empty rest.id}">
    <c:url value="/rest/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${empty rest.id}">
        <label for="curr_id">Currency</label>
        <input type="text" name="curr_id" id="curr_id">
        <label for="workshift_id">Workshift</label>
        <input type="text" name="workshift_id" id="workshift_id">
        <label for="sum">Sum</label>
        <input type="number" step="2" name="sum" id="sum">
    </c:if>
    <c:if test="${!empty rest.id}">
        <input type="hidden" name="id" value="${rest.id}">
        <label for="curr_id">Currency</label>
        <input type="text" name="curr_id" id="curr_id" value="${rest.currency.id}">
        <label for="workshift_id">Workshift</label>
        <input type="text" name="workshift_id" id="workshift_id" value="${rest.workshift.id}">
        <label for="sum">Sum</label>
        <input type="number" step="2" name="sum" id="sum" value="${rest.sum}">
    </c:if>
    <c:if test="${empty rest.id}">
        <input type="submit" value="Add new rest">
    </c:if>
    <c:if test="${!empty rest.id}">
        <input type="submit" value="Edit rest">
    </c:if>
</form>
</body>
</html>
