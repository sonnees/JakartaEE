package vn.edu.iuh.fit.backend.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum ProductStatus {
    ACTIVE(1),//đang kinh doanh
    IN_ACTIVE(0), //tam ngung
    TERMINATED(-1); //khong ban nua
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
