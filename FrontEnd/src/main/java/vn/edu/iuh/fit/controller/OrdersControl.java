package vn.edu.iuh.fit.controller;

import enums.ProductStatus;
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
import java.util.Arrays;
import java.util.List;

@WebServlet("/OrdersControl")
public class OrdersControl extends HttpServlet {
    ProductModel productModel = new ProductModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            switch (action) {
                case "":
                    List<Product> fromXtoY = productModel.getFromXtoY(1, 5);
                    List<Long> listID = new ArrayList<>();
                    fromXtoY.forEach(p->{
                        listID.add(p.getId());
                    });

                    req.setAttribute("list_product", fromXtoY);
                    req.setAttribute("list_pathImg", productModel.getPathIMGListID(listID));
                    req.setAttribute("list_price", productModel.getPriceListID(listID));

                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/buy_product.jsp");
                    requestDispatcher.forward(req, resp);
                    break;
                case "kl":
                    break;
            }

        } catch (URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
