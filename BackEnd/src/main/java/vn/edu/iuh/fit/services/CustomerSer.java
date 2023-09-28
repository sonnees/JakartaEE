package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.CustomerDao;
import vn.edu.iuh.fit.repositories.ProductDao;

import java.util.List;

public class CustomerSer {
    @Inject
    private CustomerDao dao;

    @Inject
    public CustomerSer(CustomerDao customerDao) {
        this.dao = customerDao;
    }

    public List<Customer> getAll(){
        return dao.getAll();
    }

    public Customer searchById(long id){
        return dao.searchById(id);
    }

    public List<Customer> getFromXToY(int x, int y){
        return dao.getFromXToY(x,y);
    };

    public boolean add(Customer customer){
        return dao.add(customer);
    }

    public boolean updateField(long id, String nameField, String newValue){
        return dao.updateField(id,nameField,newValue);
    }
    public boolean del(long id){
        return dao.del(id);
    }

}
