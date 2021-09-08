package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Group;
import com.example.esapracticalwork1.model.Student;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreateStudentServlet", value = "/CreateStudentServlet", urlPatterns = "/create-student")
public class CreateStudentServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> groupIds = appBean.getAllGroups().stream().map(Group::getId).collect(Collectors.toList());
        request.setAttribute("groupIds", groupIds);
        request.getRequestDispatcher("view/CreateStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        appBean.createStudent(new Student(firstName, lastName, dateOfBirth), groupId);
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
