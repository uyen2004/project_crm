package com.uyen.crm.controller;

import com.uyen.crm.model.Role;
import com.uyen.crm.repository.RoleRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "roleAdd", urlPatterns = {"/roleadd"})
public class RollAddPage extends HttpServlet {
    private RoleRepository roleRepository = new RoleRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        req.setAttribute("role", roleRepository.addRole(name, description));
        System.out.println(name + " "+ description);
        req.getRequestDispatcher("/role-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/role-add.jsp").forward(req, resp);
    }
}
