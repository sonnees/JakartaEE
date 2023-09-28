package vn.edu.iuh.fit.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmployeeStatus {
    active(1), noActive(0), terminal(-1);

    private int value;
    EmployeeStatus(int i) {
        this.value = i;
    }

    @JsonValue
    public int getValue() {
        return value;
    }

    @JsonCreator
    public static EmployeeStatus fromValue(int value) {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid EmployeeStatus value: " + value);
    }
}
