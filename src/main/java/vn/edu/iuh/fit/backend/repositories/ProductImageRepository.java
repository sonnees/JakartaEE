package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}