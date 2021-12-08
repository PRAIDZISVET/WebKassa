<%--
  Created by IntelliJ IDEA.
  Date: 26.11.2021
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Final Calculation</title>
</head>
<body>
<h2>Check the data and conirm:</h2>
<br><br>
<h3>${receipt.oper.name}</h3>
<br><br>
<form:form action="/receipt/finalcalc" modelAttribute="receipt" method="POST">
        <table>
            <tr>
                <td><form:hidden path="oper.id"/></td>
            </tr>
            <c:if test="${receipt.oper.client || (!receipt.oper.client && receipt.oper.incom)}">
            <tr>
                <td><form:label path="rate.currIn">CurrIn:</form:label></td>
                <td><form:input readonly="true" path="rate.currIn.name"/></td>
            </tr>
            <tr>
                <td><form:label path="sumIn">SumIn:</form:label></td>
                <td><form:input readonly="true" path="sumIn"/></td>
            </tr>
            </c:if>
            <c:if test="${receipt.oper.client}">
            <tr>
                <td><form:label path="rate.value">Rate:</form:label></td>
                <td><form:input readonly="true" path="rate.value"/></td>
                <td><form:hidden path="rate.id"/></td>
            </tr>
            </c:if>
            <c:if test="${receipt.oper.client || (!receipt.oper.client && !receipt.oper.incom)}">
            <tr>
                <td><form:label path="rate.currOut">CurrOut:</form:label></td>
                <td><form:input readonly="true" path="rate.currOut.name"/></td>
            </tr>
            <tr>
                <td><form:label path="sumOut">SumOut:</form:label></td>
                <td><form:input readonly="true" path="sumOut"/></td>
            </tr>
            </c:if>
            <tr>
                <td><form:hidden path="workshift.id"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Confirm"/></td>
            </tr>
        </table>
</form:form>
</body>
</html>
