<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 02.11.2021
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Currencies</title>
</head>
<body>
<h2>Currencies</h2>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>iso</th>
        <th>name</th>
        <th>isactive</th>
    </tr>
    <c:forEach var="currency" items="${currencyList}">
        <tr>
            <td>${currency.id}</td>
            <td>${currency.code}</td>
            <td>${currency.iso}</td>
            <td>${currency.name}</td>
            <td>${currency.active}</td>
            <td>
                <a href="/currency/edit/${currency.id}">edit</a>
                <a href="/currency/delete/${currency.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/currency/add" var="add"/>
<a href="${add}">Add new curreny</a>
</body>
</html>

