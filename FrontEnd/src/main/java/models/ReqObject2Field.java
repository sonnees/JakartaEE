package models;

public class ReqObject2Field {
    private String field_1;
    private String field_2;

    public ReqObject2Field() {
    }

    public ReqObject2Field(String field_1, String field_2) {
        this.field_1 = field_1;
        this.field_2 = field_2;
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

    @Override
    public String toString() {
        return "ReqObject2Field{" +
                "field_1='" + field_1 + '\'' +
                ", field_2='" + field_2 + '\'' +
                '}';
    }
}
