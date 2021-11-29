<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 30.10.2021
  Time: 5:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<p>Hello admin, ${user.name} !</p>
<br><br>
<h2>Tables:</h2>
    <h2><a href="/userList">Users</a></h2>
    <h2><a href="/workplace/list">Workplaces</a></h2>
    <h2><a href="/currency/list">Currencies</a></h2>
    <h2><a href="/oper/list">Opers</a></h2>
    <h2><a href="/rate/list">Rates</a></h2>
    <h2><a href="/workshift/list">Workshifts</a></h2>
    <h2><a href="/rest/list">Rests</a></h2>
    <h2><a href="/receipt/list">Receipts</a></h2>
</body>
</html>
