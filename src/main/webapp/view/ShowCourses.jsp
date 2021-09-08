<%@ page import="com.example.esapracticalwork1.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.esapracticalwork1.model.Student" %><%--
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
<%
    List<Course> courses = (List<Course>) request.getAttribute("courses");
%>
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
        <caption>Courses</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Hours</th>
            <th>Group</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Course course: courses) { %>
        <tr>
            <td><%= course.getId() %></td>
            <td><%= course.getName() %></td>
            <td><%= course.getHours() %></td>
            <td><%= course.getGroup().getId() %></td>
            <td>Update
            </td>
            <td>Delete
            </td>
        </tr>
        <% } %>
        </tbody>


    </table>
    <form action="${pageContext.request.contextPath}/create-course" method="get">
        <button class="btn">Create</button>
    </form>
</div>
</body>
</html>
