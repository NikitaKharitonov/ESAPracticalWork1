package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteGroupServlet", value = "/DeleteGroupServlet", urlPatterns = "/delete-group")
public class DeleteGroupServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        appBean.deleteGroup(groupId);
        response.sendRedirect(request.getContextPath() + "/groups");
    }
}
