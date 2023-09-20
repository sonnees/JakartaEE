package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import jakarta.persistence.Id;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.ProductDao;

import java.util.List;
public class ProductSer {
    @Inject
    private ProductDao productDao;

    @Inject
    public ProductSer(ProductDao productDao) {
        this.productDao = productDao;
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
    public List<Product> getFromXToY(int x, int y){return productDao.getFromXToY(x,y);};
}
