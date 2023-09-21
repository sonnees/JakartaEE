package vn.edu.iuh.fit.services;


import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositories.ProductPriceDao;

import java.time.LocalDateTime;
import java.util.List;

public class ProductPriceSer {
    @Inject
    private  ProductPriceDao dao;
    @Inject
    public ProductPriceSer(ProductPriceDao productPriceDao) {
        this.dao = productPriceDao;
    }


    public boolean add(ProductPrice productPrice){
        return dao.add(productPrice);
    }
    public boolean del(long productId, LocalDateTime priceDateTime){
        return dao.del(productId,priceDateTime);
    }
    public ProductPrice searchById(long productId,LocalDateTime priceDateTime){
        return dao.searchById(productId,priceDateTime);
    }
    public List<ProductPrice> getAll(){
        return dao.getAll();
    }
    public List<ProductPrice> getFromXToY(int x, int y){return dao.getFromXToY(x,y);}
}
