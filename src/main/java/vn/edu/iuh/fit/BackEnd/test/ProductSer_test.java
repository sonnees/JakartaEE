package vn.edu.iuh.fit.BackEnd.test;

import vn.edu.iuh.fit.BackEnd.enums.ProductStatus;
import vn.edu.iuh.fit.BackEnd.models.Product;
import vn.edu.iuh.fit.BackEnd.repositories.ProductDao;
import vn.edu.iuh.fit.BackEnd.services.ProductSer;

public class ProductSer_test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        ProductSer productSer = new ProductSer(productDao);
        boolean add = productSer.add(new Product( 100,
                "ok", "100%", "kg", "ok", ProductStatus.noActive
        ));
        System.out.println(add);

//        Product product = productSer.searchById(29);
//        System.out.println(product);

    }
}
