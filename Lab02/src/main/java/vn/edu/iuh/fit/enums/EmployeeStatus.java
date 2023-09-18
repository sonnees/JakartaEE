package vn.edu.iuh.fit.enums;

public enum EmployeeStatus {
    active(1), noActive(0), terminal(-1);

    private int value;
    EmployeeStatus(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
