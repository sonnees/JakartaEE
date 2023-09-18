package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    active(1), noActive(0), terminal(-1);

    private int value;
    ProductStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
