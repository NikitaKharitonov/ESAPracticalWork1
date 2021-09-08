<%@ page import="java.util.List" %>
<%@ page import="com.example.esapracticalwork1.model.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create course</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Long> groupIds = (List<Long>) request.getAttribute("groupIds"); %>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/create-course">
        <h1>Create course</h1>
        <div class="form-group">
            <label for="name">Name: </label>
            <input class="form-control" id="name" name="name" type="text" required/>
        </div>
        <div class="form-group">
            <label for="hours">Hours: </label>
            <input class="form-control" id="hours" name="hours" type="number" min="1" max="1000"
                   required/>
        </div>
        <div class="form-group">
            <label for="groupId">Group id: </label>
            <select class="form-control" id="groupId" name="groupId" required>
                <% for (Long groupId : groupIds) {%>
                <option value="<%= groupId %>"><%= groupId %>
                </option>
                <%}%>
            </select>
        </div>
        <br>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
