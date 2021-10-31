<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 31.10.2021
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>Users</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>role</th>
        <th>action</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role.name}</td>
            <td>
                <a href="/editUser/${user.id}">edit</a>
                <a href="/deleteUser/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addUser" var="addUser"/>
<a href="${addUser}">Add new user</a>
</body>
</html>
