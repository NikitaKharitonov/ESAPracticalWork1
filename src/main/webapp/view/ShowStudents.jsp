<%@ page import="com.example.esapracticalwork1.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 08.09.2021
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <style>
        <%@ include file="../resources/css/style.css"%>
    </style>
</head>
<body>

<%
    List<Student> students = (List<Student>) request.getAttribute("students");
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
        <caption>Students</caption>
        <thead>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Date of birth</th>
            <th>Group</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% for (Student student : students) { %>
        <tr>
            <td><%= student.getId() %>
            </td>
            <td><%= student.getFirstName() %>
            </td>
            <td><%= student.getLastName() %>
            </td>
            <td><%= student.getDateOfBirth() %>
            <td><%= student.getGroup().getId() %></td>
            <td>Update
            </td>
            <td>Delete
            </td>
        </tr>
        <% } %>
        </tbody>


    </table>
    <form action="${pageContext.request.contextPath}/create-student" method="get">
        <button class="btn">Create</button>
    </form>
</div>

</body>
</html>
