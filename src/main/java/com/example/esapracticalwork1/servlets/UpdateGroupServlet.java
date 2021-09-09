package com.example.esapracticalwork1.servlets;

import com.example.esapracticalwork1.ejb.AppBean;
import com.example.esapracticalwork1.model.Group;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateGroupServlet", value = "/UpdateGroupServlet", urlPatterns = "/update-group")
public class UpdateGroupServlet extends HttpServlet {

    @EJB
    AppBean appBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        Group group = appBean.getGroupById(groupId);
        request.setAttribute("group", group);
        request.getRequestDispatcher("view/UpdateGroup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long groupId = Long.parseLong(request.getParameter("groupId"));
        Integer year = Integer.parseInt(request.getParameter("year"));
        appBean.updateGroup(groupId, new Group(year));
        response.sendRedirect(request.getContextPath() + "/groups");
    }
}
