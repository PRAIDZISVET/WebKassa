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
    <title>Rates</title>
</head>
<body>
<h2>Rates</h2>
<table>
    <tr>
        <th>id</th>
        <th>curr_in</th>
        <th>curr_out</th>
        <th>value</th>
        <th>setdatetime</th>
        <th>action</th>
    </tr>
    <c:forEach var="rate" items="${rateList}">
        <tr>
            <td>${rate.id}</td>
            <td>${rate.currIn.iso}</td>
            <td>${rate.currOut.iso}</td>
            <td>${rate.value}</td>
            <td>${rate.setDateTime}</td>
            <td>
                <a href="/rate/edit/${rate.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/rate/add" var="add"/>
<a href="${add}">Add new rate</a>
</body>
</html>

