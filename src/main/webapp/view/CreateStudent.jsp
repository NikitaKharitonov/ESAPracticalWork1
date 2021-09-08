<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 08.09.2021
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
    <style>
        <%@ include file="../resources/css/style.css"%>
    </style>
</head>
<body>
<div class="form-container">
    <% List<Long> groupIds = (List<Long>) request.getAttribute("groupIds"); %>
    <form method="post" action="${pageContext.request.contextPath}/create-student">
        <h1>Create student</h1>
        <label>First name:
            <input name="firstName" type="text" required/>
        </label>
        <label>Last name:
            <input name="lastName" type="text" required/>
        </label>
        <label>Date of birth:
            <input name="dateOfBirth" type="date" required>
        </label>
        <label>Group id:
            <select name="groupId" required>
                <% for(Long groupId: groupIds) {%>
                <option value="<%= groupId %>"><%= groupId %></option>
                <%}%>
            </select>
        </label>
        <input type="submit" value="Create" class="btn"/>
    </form>
</div>
</body>
</html>
