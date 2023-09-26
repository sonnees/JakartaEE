package vn.edu.iuh.fit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        if(name.equals("teo") && pwd.equals("123")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard_admin.jsp");
            requestDispatcher.forward(req,resp);
        }
        else if(name.equals("met") && pwd.equals("123")){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard_user.jsp");
            requestDispatcher.forward(req,resp);
        }
        else resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
