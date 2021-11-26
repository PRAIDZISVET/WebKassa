<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 26.11.2021
  Time: 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CURRENCY EXCHANGE</title>
</head>
<body>
<h2>Enter currency and sum:</h2>
<form action="${var}" method="POST">
    <label for="currIn">CurrIn</label>

    <table>
        <c:forEach var="currIn" items="${currList}">
            <li>
                <input type="radio" name="currIn" id="currIn" value="${currIn.id}"/>${currIn.name}<br><br>
            </li>
        </c:forEach>

    </table>

    <label for="sumIn">SumIn</label>
    <input type="number" name="sumIn" id="sumIn" value="${receipt.sum}">
    <label for="currOut">CurrOut</label>
    <c:forEach var="currIn" items="${currList}">
        <tr>
            <input type="radio" name="currOut" id="currOut" value="${currIn.iso}">
        </tr>
    </c:forEach>
    <label for="sumOut">SumOut</label>
    <input type="number" name="sumOut" id="sumOut" value="${receipt.sum}">
    <input type="submit" value="Next">
</form>
</body>
</html>
