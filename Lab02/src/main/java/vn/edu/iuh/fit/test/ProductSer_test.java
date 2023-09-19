package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.services.ProductSer;

public class ProductSer_test {
    public static void main(String[] args) {
        ProductSer productSer = new ProductSer();
        boolean add = productSer.add(new Product(
                "Bang", "son", "oke", "oke", ProductStatus.active
        ));
        System.out.println(add);
    }
}
