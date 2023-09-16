package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.services.LogServices;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewLogCtrl")
public class ViewLogCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Log> logs = LogServices.getLogs();
        req.setAttribute("listLogs",logs);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/viewLog.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
