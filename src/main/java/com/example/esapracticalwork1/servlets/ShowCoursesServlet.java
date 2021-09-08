package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Student;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowCoursesServlet", value = "/ShowCoursesServlet", urlPatterns = "/courses")
public class ShowCoursesServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = appBean.getAllCourses();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("view/ShowCourses.jsp").forward(request, response);
    }
}
