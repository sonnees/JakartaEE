package vn.edu.iuh.fit.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.models.Orders;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.OrderDao;
import vn.edu.iuh.fit.repositories.ProductDao;

import java.util.List;

public class OrdersSer {
    @Inject
    private OrderDao dao;

    @Inject
    public OrdersSer(OrderDao orderDao) {
        this.dao = orderDao;
    }

    public List<Orders> getAll(){
        return dao.getAll();
    }

    public Orders searchById(long id){
        return dao.searchById(id);
    }

    public List<Orders> getFromXToY(int x, int y){
        return dao.getFromXToY(x,y);
    };

    public boolean add(Orders orders){
        return dao.add(orders);
    }

    public boolean updateField(long id, String nameField, String newValue){
        return dao.updateField(id,nameField,newValue);
    }
    public boolean del(long id){
        return dao.del(id);
    }

}
