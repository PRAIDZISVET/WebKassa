<%--
  Created by IntelliJ IDEA.
  User: SASHA
  Date: 26.11.2021
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Final Calculation</title>
</head>
<body>
<h2>Check the data and submit:</h2>
<label for="currIn">CurrIn</label>
<input type="text" name="currIn" id="currIn" value="${currIn.iso}">
<label for="sumIn">SumIn</label>
<input type="number" name="sumIn" id="sumIn" value="${receipt.sum}">
<label for="currOut">CurrOut</label>
<input type="text" name="currOut" id="currOut" value="${currIn.iso}">
<label for="sumOut">SumOut</label>
<input type="number" name="sumOut" id="sumOut" value="${receipt.sum}">
<input type="submit" value="Make an exchange">
<label for="rate">Rate</label>
<input type="text" name="rate" id="rate" value="${receipt.workshift.id}">
</body>
</html>
