package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select pi.PATH, p.*,pp.PRICE,pp.PRICE_DATE_TIME from PRODUCT p " +
            "left join ( " +
            "    select pp1.PRODUCT_ID, pp1.PRICE,pp1.PRICE_DATE_TIME from PRODUCT_PRICE pp1 " +
            "    where pp1.PRICE_DATE_TIME = (select MAX(pp2.PRICE_DATE_TIME) " +
            "                                 from PRODUCT_PRICE pp2 " +
            "                                 where pp2.PRODUCT_ID = pp1.PRODUCT_ID) " +
            ")  pp " +
            "on p.PRODUCT_ID = pp.PRODUCT_ID " +
            "left join PRODUCT_IMAGE pi " +
            "on  pi.PRODUCT_ID = p.PRODUCT_ID where STATUS !=2 " +
            "group by p.PRODUCT_ID,pp.PRICE ", nativeQuery = true)
    Page<Object[]> getProduct(Pageable pageable);
}