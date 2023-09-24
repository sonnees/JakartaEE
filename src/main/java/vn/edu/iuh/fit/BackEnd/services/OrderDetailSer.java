package vn.edu.iuh.fit.BackEnd.services;


import jakarta.inject.Inject;
import vn.edu.iuh.fit.BackEnd.models.OrderDetail;
import vn.edu.iuh.fit.BackEnd.models.ProductPrice;
import vn.edu.iuh.fit.BackEnd.repositories.OrderDetailDao;
import vn.edu.iuh.fit.BackEnd.repositories.ProductPriceDao;

import java.util.List;

public class OrderDetailSer {
    @Inject
    private OrderDetailDao dao;
    @Inject
    public OrderDetailSer(OrderDetailDao orderDetailDao) {
        this.dao = orderDetailDao;
    }

    public OrderDetail searchById(OrderDetail orderDetail){
        return dao.searchById(orderDetail);
    }
    public List<OrderDetail> getAll(long orders_id){
        return dao.getAll(orders_id);
    }
    public boolean add(OrderDetail obj){
        return dao.add(obj);
    }
    public boolean del(OrderDetail obj){
        return dao.del(obj);
    }

}
