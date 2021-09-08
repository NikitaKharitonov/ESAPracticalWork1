package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CreateCourseServlet", value = "/CreateCourseServlet", urlPatterns = "/create-course")
public class CreateCourseServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Long> groupIds = appBean.getAllGroups().stream().map(Group::getId).collect(Collectors.toList());
        request.setAttribute("groupIds", groupIds);
        request.getRequestDispatcher("view/CreateCourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer hours = Integer.parseInt(request.getParameter("hours"));
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        appBean.createCourse(new Course(name, hours), groupId);
        response.sendRedirect(request.getContextPath() + "/courses");
    }
}
