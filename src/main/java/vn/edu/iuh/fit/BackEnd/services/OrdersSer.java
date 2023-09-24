package vn.edu.iuh.fit.BackEnd.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.BackEnd.models.Orders;
import vn.edu.iuh.fit.BackEnd.models.Product;
import vn.edu.iuh.fit.BackEnd.models.ReqObject3Field;
import vn.edu.iuh.fit.BackEnd.repositories.OrderDao;
import vn.edu.iuh.fit.BackEnd.repositories.ProductDao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    }

    public Map<String,Integer> getAnalYearMonthDay(ReqObject3Field reqObject3Field){return dao.getAnalYearMonthDay(reqObject3Field);}
    public Map<String,Integer> getAnalYearMonths(ReqObject3Field reqObject3Field){return dao.getAnalYearMonths(reqObject3Field);}
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
