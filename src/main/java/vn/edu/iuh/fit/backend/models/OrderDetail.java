package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.pks.OrderDetailPK;

@Entity
@Table(name = "order_detail")
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    @Column(name = "quantity", nullable = false)
    private double quantity;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "note", length = 255, nullable = true)
    private String note;

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(double quantity, double price, String note, Order order, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.note = note;
        this.order = order;
        this.product = product;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
