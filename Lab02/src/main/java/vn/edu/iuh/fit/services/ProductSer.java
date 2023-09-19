package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositories.ProductDao;
import vn.edu.iuh.fit.repositories.ProductPriceDao;

import java.time.LocalDateTime;
import java.util.List;
public class ProductSer {
    private ProductDao productDao;

    public ProductSer() {
        productDao = new ProductDao();
    }

    public boolean add(Product product){

        return productDao.add(product);
    }
    public boolean del(long id){
        return productDao.del(id);
    }
    public Product searchById(long id){
        return productDao.searchById(id);
    }
    public List<Product> getAll(){

        return productDao.getAll();
    }
}
