package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositories.ProductDao;
import vn.edu.iuh.fit.repositories.ProductPriceDao;
import vn.edu.iuh.fit.services.ProductPriceSer;
import vn.edu.iuh.fit.services.ProductSer;

import java.time.LocalDateTime;

public class ProductPriceSer_test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        ProductSer productSer = new ProductSer(productDao);

        ProductPriceDao productPriceDao = new ProductPriceDao();
        ProductPriceSer productPriceSer = new ProductPriceSer(productPriceDao);
        boolean hi = productPriceSer.addProductPrice(
                new ProductPrice(
                        LocalDateTime.of(2012,12,21,6,30),
                        1000.0,
                        "hi",
                        productSer.searchById(1)
                )
        );

        System.out.println(hi);
    }
}
