package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Group;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreateGroupServlet", value = "/CreateGroupServlet", urlPatterns = "/create-group")
public class CreateGroupServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/CreateGroup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer year = Integer.parseInt(request.getParameter("year"));
        appBean.createGroup(new Group(year));
        response.sendRedirect(request.getContextPath() + "/groups");
    }
}
