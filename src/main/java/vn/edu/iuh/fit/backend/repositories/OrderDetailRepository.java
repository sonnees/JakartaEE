package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.pks.OrderDetailPK;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}