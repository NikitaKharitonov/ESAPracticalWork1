package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", value = "/DeleteStudentServlet", urlPatterns = "/delete-student")
public class DeleteStudentServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long studentId = Long.parseLong(request.getParameter("studentId"));
        appBean.deleteStudent(studentId);
        response.sendRedirect(request.getContextPath() + "/students");
    }
}
