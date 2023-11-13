package vn.edu.iuh.fit.backend.mapping;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

@AllArgsConstructor
@Component
public class ProductStatusMap {
    public ProductStatus toProductStatus(String status){
        return switch (status) {
            case "0" -> ProductStatus.IN_ACTIVE;
            case "2" -> ProductStatus.TERMINATED;
            default -> ProductStatus.ACTIVE;
        };
    }
}
