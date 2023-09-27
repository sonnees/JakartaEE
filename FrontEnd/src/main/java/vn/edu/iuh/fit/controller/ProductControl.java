package vn.edu.iuh.fit.controller;

import enums.ProductStatus;
import jakarta.inject.Inject;
import jakarta.persistence.Id;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Product;
import models.ReqObject2Field;
import models.ReqObject3Field;
import vn.edu.iuh.fit.model.ProductModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.nio.file.Files.delete;

@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
    ProductModel productModel = new ProductModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("1 "+action);
        try {
            switch (action) {
                case "":
                    req.setAttribute("list", productModel.getAll());

                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/product-crud.jsp");
                    requestDispatcher.forward(req, resp);
                    break;
                case "insert":
                    insert(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                case "Anal-Year-Month-Day":
                    System.out.println("2");
                    analYearMonthDay(req, resp);
                    break;
                case "Anal-Years-Months":
                    analYearsMonths(req, resp);
                    break;
            }

        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void analYearsMonths(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, URISyntaxException, InterruptedException {
        String aFor = req.getParameter("for");
        RequestDispatcher requestDispatcher = null;
        if(aFor==null){
            req.setAttribute("date","2023-09-01");
            req.setAttribute("list", new ArrayList<>());
            requestDispatcher = req.getRequestDispatcher("/WEB-INF/orders_Anals.jsp");
            requestDispatcher.forward(req,resp);
        }

        String[] dates = req.getParameter("date").split("-");
        List<ReqObject2Field> reqObject2Fields =null;

        if(aFor.equals("Day"))
            reqObject2Fields = productModel.analYearsMonths(new ReqObject3Field(
                    dates[0], dates[1], dates[2]));
        else if (aFor.equals("Month"))
            reqObject2Fields = productModel.analYearsMonths(new ReqObject3Field(
                    dates[0], dates[1], "0"));
        else
            reqObject2Fields = productModel.analYearsMonths(new ReqObject3Field(
                    dates[0], "0", "0"));
        req.setAttribute("date",req.getParameter("date"));
        req.setAttribute("list", reqObject2Fields);
        requestDispatcher = req.getRequestDispatcher("/WEB-INF/orders_Anals.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void analYearMonthDay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, URISyntaxException, InterruptedException {
        System.out.println("3");
        String aFor = req.getParameter("for");
        if(aFor==null){
            System.out.println("3.1");
            req.setAttribute("date","2023-09-01");
            req.setAttribute("list", new ArrayList<>());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/orders_Anal.jsp");
            requestDispatcher.forward(req,resp);
        }

        String[] dates = req.getParameter("date").split("-");
        List<ReqObject2Field> reqObject2Fields =null;
        System.out.println("3.2");
        if(aFor.equals("Day"))
            reqObject2Fields = productModel.analYearMonthDay(new ReqObject3Field(
                    dates[0], dates[1], dates[2]));
        else if (aFor.equals("Month"))
            reqObject2Fields = productModel.analYearMonthDay(new ReqObject3Field(
                    dates[0], dates[1], "0"));
        else
            reqObject2Fields = productModel.analYearMonthDay(new ReqObject3Field(
                    dates[0], "0", "0"));
        req.setAttribute("date",req.getParameter("date"));
        req.setAttribute("list", reqObject2Fields);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/orders_Anal.jsp");
        requestDispatcher.forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws URISyntaxException, IOException, InterruptedException, ServletException {
        String id = req.getParameter("id");
        boolean delete = productModel.delete(Integer.parseInt(id));
        if (delete) {
            req.setAttribute("result", "true");
        } else req.setAttribute("result", "false");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ControlServlet?action=product_crud");
        requestDispatcher.forward(req,resp);
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String unit = req.getParameter("unit");
        String manufacturer = req.getParameter("manufacturer");
        String status = req.getParameter("status");

        ProductStatus productStatus = null;
        if (status.equals("-1"))
            productStatus = ProductStatus.terminal;
        else if (status.equals("0"))
            productStatus = ProductStatus.noActive;
        else productStatus = ProductStatus.active;

        Product product = new Product(
                name, description, unit, manufacturer, productStatus
        );
        boolean add = false;
        try {
            add = productModel.add(product);
        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        if (add) {
            req.setAttribute("result", "true");
        } else req.setAttribute("result", "false");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ControlServlet?action=product_crud");
        requestDispatcher.forward(req, resp);
    }
}
