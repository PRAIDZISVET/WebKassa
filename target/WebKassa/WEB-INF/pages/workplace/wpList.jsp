<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 02/11/2021
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Workplaces</title>
</head>
<body>
<h2>Workplaces</h2>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>address</th>
    </tr>
    <c:forEach var="workplace" items="${workplaceList}">
        <tr>
            <td>${workplace.id}</td>
            <td>${workplace.code}</td>
            <td>${workplace.name}</td>
            <td>${workplace.address}</td>
            <td>
                <a href="/workplace/edit/${workplace.id}">edit</a>
                <a href="/workplace/delete/${workplace.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/workplace/add" var="add"/>
<a href="${add}">Add new workplace</a>
</body>
</html>

