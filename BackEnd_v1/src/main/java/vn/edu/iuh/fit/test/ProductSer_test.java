package vn.edu.iuh.fit.test;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.enums.ProductStatus;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.ProductDao;
import vn.edu.iuh.fit.services.ProductSer;

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
