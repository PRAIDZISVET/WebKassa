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
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Receipts</title>
</head>
<body>
<h2>Receipts</h2>
<table>
    <tr>
        <th>id</th>
        <th>oper</th>
        <th>workshift</th>
        <th>rate</th>
        <th>datetime</th>
        <th>sumIn</th>
        <th>currIn</th>
        <th>sumOut</th>
        <th>currOut</th>
        <th>action</th>
    </tr>
    <c:forEach var="receipt" items="${receiptList}">
        <tr>
            <td>${receipt.id}</td>
            <td>${receipt.oper.name}</td>
            <td>${receipt.workshift.id}</td>
            <td>${receipt.rate.value}</td>
            <td>${receipt.dateTime}</td>
            <td>${receipt.sumIn}</td>
            <td>${receipt.rate.currIn.iso}</td>
            <td>${receipt.sumOut}</td>
            <td>${receipt.rate.currOut.iso}</td>
            <td>
                <a href="/receipt/edit/${receipt.id}">edit</a>
                <a href="/receipt/delete/${receipt.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/receipt/add" var="add"/>
<a href="${add}">Add new receipt</a>
</body>
</html>
