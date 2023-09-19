package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import org.apache.commons.logging.impl.SLF4JLog;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositories.ProductPriceDao;

import java.time.LocalDateTime;
import java.util.List;

public class ProductPriceSer {

    private  ProductPriceDao productPriceDao;

    public ProductPriceSer() {
        productPriceDao = new ProductPriceDao();
    }

    public boolean addProductPrice(ProductPrice productPrice){
        return productPriceDao.addProductPrice(productPrice);
    }
    public boolean delProductPrice(long productId, LocalDateTime priceDateTime){
        return productPriceDao.delProductPrice(productId,priceDateTime);
    }
    public ProductPrice searchProductPriceById(long productId,LocalDateTime priceDateTime){
        return productPriceDao.searchProductPriceById(productId,priceDateTime);
    }
    public List<ProductPrice> getAll(){
        return productPriceDao.getAll();
    }
}
