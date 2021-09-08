<%@ page import="java.util.List" %>
<%@ page import="com.example.esapracticalwork1.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<%
    List<Long> groupIds = (List<Long>) request.getAttribute("groupIds");
    Student student = (Student) request.getAttribute("student");
%>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/update-student">
        <h1>Update student</h1>
        <input type="hidden" name="studentId" value="<%= student.getId() %>">
        <div class="form-group">
            <label for="fname">First name: </label>
            <input class="form-control" id="fname" name="firstName" type="text" value="<%= student.getFirstName() %>"
                   required/>
        </div>
        <div class="form-group">
            <label for="lname">Last name: </label>
            <input class="form-control" id="lname" name="lastName" type="text" value="<%= student.getLastName() %>"
                   required/>
        </div>
        <div class="form-group">
            <label for="dob">Date of birth: </label>
            <input class="form-control" id="dob" name="dateOfBirth" type="date" value="<%= student.getDateOfBirth() %>"
                   required>
        </div>
        <div class="form-group">
            <label for="groupId">Group id: </label>
            <select class="form-control" id="groupId" name="groupId" required>
                <% for (Long groupId : groupIds) {%>
                <% if (groupId.equals(student.getGroup().getId())) {%>
                <option value="<%= groupId %>"><%= groupId %>
                </option>
                <%} else {%>
                <option value="<%= groupId %>" selected><%= groupId %>
                </option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <br>
        <input type="submit" value="Update" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
