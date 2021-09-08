<%@ page import="com.example.esapracticalwork1.model.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.esapracticalwork1.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>
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
        <caption style="caption-side: top">Courses</caption>
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
        <% for (Course course : courses) { %>
        <tr>
            <td><%= course.getId() %>
            </td>
            <td><%= course.getName() %>
            </td>
            <td><%= course.getHours() %>
            </td>
            <td><%= course.getGroup().getId() %>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/update-course">
                    <input type="hidden" name="courseId" value="<%= course.getId() %>">
                    <input type="submit" value="Update" class="btn btn-primary">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/delete-course" method="post">
                    <input type="hidden" name="courseId" value="<%= course.getId() %>">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <form action="${pageContext.request.contextPath}/create-course" method="get">
        <button class="btn btn-primary">Create course</button>
    </form>
</div>
</body>
</html>
