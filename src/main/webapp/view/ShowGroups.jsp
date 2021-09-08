<%@ page import="java.util.List" %>
<%@ page import="com.example.esapracticalwork1.model.Group" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 08.09.2021
  Time: 17:11
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

<% List<Group> groups = (List<Group>) request.getAttribute("groups"); %>
<div class="container-table">
    <form action="${pageContext.request.contextPath}/groups" method="get">
        <button class="btn">Show groups</button>
    </form>
    <form action="${pageContext.request.contextPath}/courses" method="get">
        <button class="btn">Show courses</button>
    </form>
    <form action="${pageContext.request.contextPath}/students" method="get">
        <button class="btn">Show students</button>
    </form>
    <table>
        <caption>Groups</caption>
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
            <td>Update
            </td>
            <td>Delete
            </td>
        </tr>

        <% } %>
        </tbody>


    </table>
    <form action="${pageContext.request.contextPath}/create-group" method="get">
        <button class="btn">Create</button>
    </form>
</div>


</body>
</html>
