package vn.edu.iuh.fit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.Path;

import java.io.IOException;

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        RequestDispatcher requestDispatcher = null;
        switch (action){
            case "product_crud":
                requestDispatcher = req.getRequestDispatcher("/ProductControl?action=");
                requestDispatcher.forward(req,resp);
                break;
            case "orders_Anal-Year-Month-Day":
                requestDispatcher = req.getRequestDispatcher("/ProductControl?action=Anal-Year-Month-Day");
                requestDispatcher.forward(req,resp);
                break;
            case "orders_Anal-Years-Months":
                requestDispatcher = req.getRequestDispatcher("/ProductControl?action=Anal-Years-Months");
                requestDispatcher.forward(req,resp);
                break;
        }


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
