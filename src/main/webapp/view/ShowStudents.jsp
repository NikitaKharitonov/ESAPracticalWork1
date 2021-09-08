<%@ page import="com.example.esapracticalwork1.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Student> students = (List<Student>) request.getAttribute("students"); %>
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
        <caption style="caption-side: top">Students</caption>
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
            <td><%= student.getGroup().getId() %>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-student">
                    <input type="hidden" name="studentId" value="<%= student.getId() %>">
                    <input type="submit" class="btn btn-primary" value="Update">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-student" method="post">
                    <input type="hidden" name="studentId" value="<%= student.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-student" method="get">
        <button class="btn btn-primary">Create student</button>
    </form>
</div>
</body>
</html>
