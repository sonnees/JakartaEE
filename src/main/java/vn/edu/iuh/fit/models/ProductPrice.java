package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "product_price")
@Entity
public class ProductPrice {
    @Id
    @Column(name = "price_date_time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime priceDateTime;
    private Double price;
    private String note;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime priceDateTime, Product product) {
        this.priceDateTime = priceDateTime;
        this.product = product;
    }

    public ProductPrice(LocalDateTime priceDateTime, Double price, String note, Product product) {
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
        this.product = product;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    @JsonSetter
    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPrice)) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(priceDateTime, that.priceDateTime) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceDateTime, product);
    }
}
