package vn.edu.iuh.fit.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ProductDTO {
    private String path;
    private long id;
    private String description;
    private String manufacturer;
    private String name;
    private ProductStatus status;
    private String unit;
    private double price;
    private LocalDateTime price_date_time;
}
