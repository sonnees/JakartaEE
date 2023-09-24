package vn.edu.iuh.fit.BackEnd.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductStatus {
    terminal(-1), noActive(0),active(1);

    private int value;
    ProductStatus(int i) {
        this.value = i;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static ProductStatus fromValue(int value) {
        for (ProductStatus status : ProductStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ProductStatus value: " + value);
    }
}
