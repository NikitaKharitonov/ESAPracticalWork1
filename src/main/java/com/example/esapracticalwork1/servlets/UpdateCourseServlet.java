package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "UpdateCourseServlet", value = "/UpdateCourseServlet", urlPatterns = "/update-course")
public class UpdateCourseServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        Course course = appBean.getCourseById(courseId);
        request.setAttribute("course", course);
        List<Long> groupIds = appBean.getAllGroups().stream().map(Group::getId).collect(Collectors.toList());
        request.setAttribute("groupIds", groupIds);
        request.getRequestDispatcher("view/UpdateCourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        String name = request.getParameter("name");
        Integer hours = Integer.parseInt(request.getParameter("hours"));
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        appBean.updateCourse(courseId, new Course(name, hours), groupId);
        response.sendRedirect(request.getContextPath() + "/courses");
    }
}
