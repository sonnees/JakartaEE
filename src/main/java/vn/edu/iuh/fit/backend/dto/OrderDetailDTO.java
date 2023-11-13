package vn.edu.iuh.fit.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    private Long idP;
    private String imgP;
    private String nameP;
    private Double priceP;
    private int quantity;
}
