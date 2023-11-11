package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.backend.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from ORDERS where ORDER_DATE = '9999-01-01 01:01:01.000000'",nativeQuery = true)
    Order getOrderByDate();
}