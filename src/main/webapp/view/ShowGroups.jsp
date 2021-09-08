<%@ page import="java.util.List" %>
<%@ page import="com.example.esapracticalwork1.model.Group" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Group> groups = (List<Group>) request.getAttribute("groups"); %>
<div class="container">
    <ul class="nav justify-content-center">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/groups">Show groups</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/courses">Show courses</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/students">Show students</a>
        </li>
    </ul>
    <table class="table table-striped table-dark table-hover">
        <caption style="caption-side: top">Groups</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Year</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Group group : groups) { %>
        <tr>
            <td><%= group.getId() %>
            </td>
            <td><%= group.getYear() %>
            <td>
                <form action="${pageContext.request.contextPath}/update-group">
                    <input type="hidden" name="groupId" value="<%= group.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-group" method="post">
                    <input type="hidden" name="groupId" value="<%= group.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-group" method="get">
        <button class="btn btn-primary">Create group</button>
    </form>
</div>
</body>
</html>
