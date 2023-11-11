package vn.edu.iuh.fit.backend.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;

@Service
@AllArgsConstructor
public class OrderService {
    OrderRepository orderRepository;
    public Order getOrderByDate(){
        return orderRepository.getOrderByDate();
    }
}
