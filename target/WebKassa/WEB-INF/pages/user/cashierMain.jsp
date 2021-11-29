<%--@elvariable id="user" type=""--%>
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
    <title>Cashier MainPage</title>
</head>
<body>
 <p>Hello cashier, ${user.name} ! Workplace ${user.workplace.name},${user.workplace.address}</p>
    <c:if test="${empty workshift.id}">
            <p>Не найдено открытой смены!</p>
        </c:if>
<c:if test="${!empty workshift.id}">
 <p>Workshift № ${workshift.id} opened ${workshift.openDateTime}</p>
</c:if>
 <c:if test="${!empty message}">
     <h2>${message}</h2>
 </c:if>

<h2><a href="/workshift/open">Open workshift</a></h2>

<h2><a href="/workshift/close">Close workshift</a></h2>

 <h2>Проведение операций:</h2>

 <table>
     <c:forEach var="oper" items="${operList}">
         <tr>
             <td><a href="/receipt/make/${oper.id}/${oper.name}" onselect="${sessionScope.remove("message")} ${sessionScope.remove("restmessage")}">${oper.name}</a></td>
         </tr>
     </c:forEach>
 </table>

 <h2>Инфо:</h2>
<ul><a href="/rate/list">Курсы валют</a></ul>
<ul><a href="/rest/list">Остатки ценностей в кассе</a></ul>
<ul><a href="/receipt/list">Картотека операций за смену</a></ul>
</body>
</html>

