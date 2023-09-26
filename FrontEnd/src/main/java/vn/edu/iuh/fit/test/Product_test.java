package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.model.ProductModel;

import java.io.IOException;
import java.net.URISyntaxException;

public class Product_test {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        ProductModel productModel = new ProductModel();
        productModel.getAll().forEach(p->{
            System.out.println(p);
        });
    }
}
