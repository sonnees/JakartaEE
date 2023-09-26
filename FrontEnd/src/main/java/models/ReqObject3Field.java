package models;

public class ReqObject3Field {
    private String field_1;
    private String field_2;
    private String field_3;

    public ReqObject3Field() {
    }

    public ReqObject3Field(String field_1, String field_2, String field_3) {
        this.field_1 = field_1;
        this.field_2 = field_2;
        this.field_3 = field_3;
    }

    public String getField_1() {
        return field_1;
    }

    public void setField_1(String field_1) {
        this.field_1 = field_1;
    }

    public String getField_2() {
        return field_2;
    }

    public void setField_2(String field_2) {
        this.field_2 = field_2;
    }

    public String getField_3() {
        return field_3;
    }

    public void setField_3(String field_3) {
        this.field_3 = field_3;
    }

    @Override
    public String toString() {
        return "ReqObject3Field{" +
                "field_1='" + field_1 + '\'' +
                ", field_2='" + field_2 + '\'' +
                ", field_3='" + field_3 + '\'' +
                '}';
    }
}
