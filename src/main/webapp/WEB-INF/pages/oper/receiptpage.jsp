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
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>Currency Exchange</title>
</head>
<body>
<h2>${oper.name}</h2>
<h3>Enter currency and sum:</h3>
<c:url value="/receipt/make" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="operId" value="${oper.id}">
    <label for="curr">CurrIn</label>
    <br><br>
    <table>
            <c:forEach var="curr" items="${currList}">
                <c:if test="${curr.code != 933}">
                    <tr>
                        <td><input type="radio" name="curr" id="curr" value="${curr.id}"/></td>
                        <th>
                                ${curr.name}
                        <th>
                    </tr>
                </c:if>
            </c:forEach>
    </table>
    <br><br>
    <label for="sum">Sum</label>
    <input type="number" name="sum" id="sum">
    <br><br>
    <c:if test="${oper.id == 3}">
        <label for="currEq">CurrOut</label>
        <br><br>
        <table>
            <c:forEach var="currEq" items="${currList}">
                <c:if test="${currEq.code != 933}">
                    <tr>
                        <td><input type="radio" name="currEq" id="currEq" value="${currEq.id}"/></td>
                        <th>
                                ${currEq.name}
                        <th>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:if>
    <br><br>
    <input type="submit" value="Next">
</form>
</body>
</html>
