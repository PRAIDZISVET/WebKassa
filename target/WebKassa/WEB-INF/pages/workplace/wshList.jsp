<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 05/11/2021
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Workshifts</title>
</head>
<body>
<h2>Workshifts</h2>
<table>
    <tr>
        <th>id</th>
        <th>opendatetime</th>
        <th>closedatetime</th>
        <th>user</th>
        <th>workplace</th>

    </tr>
    <c:forEach var="workshift" items="${workshiftList}">
        <tr>
            <td>${workshift.id}</td>
            <td>${workshift.openDateTime}</td>
            <td>${workshift.closeDateTime}</td>
            <td>${workshift.user.name}</td>
            <td>${workshift.workplace.name}</td>
            <td>
                <a href="/workshift/edit/${workshift.id}">edit</a>
                <a href="/workshift/delete/${workshift.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/workshift/add" var="add"/>
<a href="${add}">Add new workshift</a>
</body>
</html>

