package com.uyen.crm.api;

import com.google.gson.Gson;
import com.uyen.crm.Payload.ResponseData;
import com.uyen.crm.repository.RoleRepository;
import com.uyen.crm.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "roleApi", urlPatterns = "/api/role")
public class RoleApi extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = roleService.deleteById(id);
        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setSuccess(isSuccess);
        responseData.setDescription(isSuccess == true? "Xoa thanh cong" : "Xoa that bai");
        resp.setContentType("application/json");
        req.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String json = gson.toJson(responseData);
        out.print(json);
        out.flush();
    }


}
