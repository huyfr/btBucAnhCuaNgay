<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Mark</td>
        <td>Author</td>
        <td>Feedback</td>
    </tr>
    <c:forEach items="${images}" var="i">
        <tr>
            <td>${i.getId()}</td>
            <td>${i.getMark()}</td>
            <td>${i.getAuthor()}</td>
            <td>${i.getFeedback()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
