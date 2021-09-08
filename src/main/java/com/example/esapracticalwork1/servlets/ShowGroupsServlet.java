package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Group;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowGroupsServlet", value = "/ShowGroupsServlet", urlPatterns = "/groups")
public class ShowGroupsServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Group> groups = appBean.getAllGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("view/ShowGroups.jsp").forward(request, response);
    }
}
