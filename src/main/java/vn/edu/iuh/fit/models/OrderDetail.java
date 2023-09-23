package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    private Double quantity;
    private Double price;
    private String note;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(Orders orders, Product product) {
        this.orders = orders;
        this.product = product;
    }

    public OrderDetail(Double quantity, Double price, String note, Orders orders, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.note = note;
        this.orders = orders;
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                ", orders=" + orders +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(orders, that.orders) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, product);
    }
}
