package vn.edu.iuh.fit.BackEnd.test;

import vn.edu.iuh.fit.BackEnd.models.ProductPrice;
import vn.edu.iuh.fit.BackEnd.repositories.ProductDao;
import vn.edu.iuh.fit.BackEnd.repositories.ProductPriceDao;
import vn.edu.iuh.fit.BackEnd.services.ProductPriceSer;
import vn.edu.iuh.fit.BackEnd.services.ProductSer;

import java.time.LocalDateTime;

public class ProductPriceSer_test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        ProductSer productSer = new ProductSer(productDao);

        ProductPriceDao productPriceDao = new ProductPriceDao();
        ProductPriceSer productPriceSer = new ProductPriceSer(productPriceDao);
//        boolean hi = productPriceSer.add(
//                new ProductPrice(
//                        LocalDateTime.of(2012,12,21,6,30),
//                        1000.0,
//                        "hi",
//                        productSer.searchById(1)
//                )
//        );
//
//        System.out.println(hi);
        LocalDateTime dateTime = LocalDateTime.of(2012,12,21,6,30);
//        ProductPrice productPrice = productPriceSer.searchById(1, dateTime);
//        System.out.println(productPrice);
    }
}
