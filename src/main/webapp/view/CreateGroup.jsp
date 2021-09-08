<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 08.09.2021
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@ include file="../resources/css/style.css"%>
    </style>
</head>
<body>
<div class="form-container">
    <form method="post" action="${pageContext.request.contextPath}/create-group">
        <h1>Create group</h1>
        <label>
            <input name="year" type="number" min="1" max="6" required/>
        </label>
        <input type="submit" value="Create" class="btn"/>
    </form>
</div>
</body>
</html>
