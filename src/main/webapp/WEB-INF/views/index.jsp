<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/06/2020
  Time: 08:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<img id="img-of-the-day" alt="nasa">
<form:form action="/result" method="post" modelAttribute="image">
    <form:hidden path="id"/>
    <form:select path="mark">
        <form:option value="1"/>
        <form:option value="2"/>
        <form:option value="3"/>
        <form:option value="4"/>
        <form:option value="5"/>
    </form:select>
    <form:label path="author">Author:</form:label>
    <form:input path="author"/>
    <form:label path="feedback">Feedback:</form:label>
    <form:textarea path="feedback"/>
    <input type="submit" value="Comment">
</form:form>
</body>
<script>
    let query = 'https://api.nasa.gov/planetary/apod?api_key=puwtpoLlfYpxhA6IQBAneoO0B0mejMe4OwotnWqq';
    let request = new XMLHttpRequest();
    request.open('GET', query);
    request.onload = function () {
        if (request.status === 200) {
            let response = JSON.parse(request.responseText);
            document.getElementById('img-of-the-day').setAttribute('src', response.url);
        }
    };
    request.send();
</script>
</html>
