package com.example.esapracticalwork1.servlets;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

import com.example.esapracticalwork1.dao.DaoUtil;
import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import com.example.esapracticalwork1.model.Student;
import jakarta.persistence.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.transaction.Transaction;

@WebServlet(name = "helloServlet", value = "/")
public class IndexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath() + "/groups");
    }
}