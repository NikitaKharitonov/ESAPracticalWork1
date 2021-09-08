package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCourseServlet", value = "/DeleteCourseServlet", urlPatterns = "/delete-course")
public class DeleteCourseServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long courseId = Long.parseLong(request.getParameter("courseId"));
        appBean.deleteCourse(courseId);
        response.sendRedirect(request.getContextPath() + "/courses");
    }
}
