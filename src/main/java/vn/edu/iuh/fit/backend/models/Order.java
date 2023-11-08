package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long order_id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(long order_id, LocalDateTime orderDate, Employee employee, Customer customer) {
        this.order_id = order_id;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public Order(LocalDateTime orderDate, Employee employee, Customer customer) {
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
