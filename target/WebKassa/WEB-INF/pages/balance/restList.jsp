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
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Rests</title>
</head>
<body>
<h2>Rests</h2>
<table>
    <tr>
        <th>id</th>
        <th>currency</th>
        <th>sum</th>
        <th>workshift</th>
        <th>action</th>
    </tr>
    <c:forEach var="rest" items="${restList}">
        <tr>
            <td>${rest.id}</td>
            <td>${rest.currency.iso}</td>
            <td>${rest.sum}</td>
            <td>${rest.workshift.id}</td>
            <td>
                <a href="/rest/edit/${rest.id}">edit</a>
                <a href="/rest/delete/${rest.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>
<c:url value="/rest/add" var="add"/>
<a href="${add}">Add new rest</a>
</body>
</html>