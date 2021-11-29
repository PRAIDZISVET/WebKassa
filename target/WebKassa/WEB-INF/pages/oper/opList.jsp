<%--
  Created by IntelliJ IDEA.
  User: maiseyeu
  Date: 03/11/2021
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Opers</title>
</head>
<body>
<h2>Opers</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>isincom</th>
        <th>isclient</th>
        <th>isactive</th>
        <th>action</th>
    </tr>
    <c:forEach var="oper" items="${operList}">
        <tr>
            <td>${oper.id}</td>
            <td>${oper.name}</td>
            <td>${oper.incom}</td>
            <td>${oper.client}</td>
            <td>${oper.active}</td>
            <td>
                <a href="/oper/edit/${oper.id}">edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/oper/add" var="add"/>
<a href="${add}">Add new oper</a>
</body>
</html>

