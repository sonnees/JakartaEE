package vn.edu.iuh.fit.BackEnd.services;

import jakarta.inject.Inject;
import jakarta.persistence.Id;
import vn.edu.iuh.fit.BackEnd.models.Product;
import vn.edu.iuh.fit.BackEnd.repositories.ProductDao;

import java.util.List;
public class ProductSer {
    @Inject
    private ProductDao dao;

    @Inject
    public ProductSer(ProductDao productDao) {
        this.dao = productDao;
    }

    public List<Product> getAll(){
        return dao.getAll();
    }

    public Product searchById(long id){
        return dao.searchById(id);
    }

    public List<Product> getFromXToY(int x, int y){
        return dao.getFromXToY(x,y);
    };

    public boolean add(Product product){
        return dao.add(product);
    }

    public boolean updateField(long id, String nameField, String newValue){
        return dao.updateField(id,nameField,newValue);
    }
    public boolean del(long id){
        return dao.del(id);
    }

}
