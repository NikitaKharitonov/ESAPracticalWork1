package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.dao.StudentDao;
import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Student;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowStudentsServlet", value = "/ShowStudentsServlet", urlPatterns = "/students")
public class ShowStudentsServlet extends HttpServlet {
    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = appBean.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("view/ShowStudents.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
