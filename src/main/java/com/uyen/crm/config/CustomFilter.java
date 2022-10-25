package com.uyen.crm.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import com.uyen.crm.controller.LoginPage;


@WebFilter(urlPatterns = "/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("filter check");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
//        if(session.getAttribute("isLogin") != null && !session.getAttribute("isLogin").equals("")){
//        boolean isLogin = (boolean) session.getAttribute("isLogin");
//        if(isLogin){
//            if(req.getServletPath().equals("/login")){
//                res.sendRedirect(req.getContextPath()+"/home");
//            }else{
//                filterChain.doFilter(req, res);
//            }
//        }else{
//            res.sendRedirect(req.getContextPath()+"/login");
//        }
//        }else {
//            if (req.getServletPath().equals("/login")) {
//                filterChain.doFilter(req, res);
//            } else {
//                res.sendRedirect(req.getContextPath() + "/login");
//            }
//        }
//    }
        filterChain.doFilter(req, res);
    }
    @Override
    public void destroy() {

    }
}
