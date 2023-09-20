package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @ManyToOne()
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private  Customer customer;

    public Orders() {
    }

    public Orders(LocalDateTime orderDate, Employee employee, Customer customer) {
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    public Orders(long id, LocalDateTime orderDate, Employee employee, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return Objects.equals(employee, orders.employee) && Objects.equals(customer, orders.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, customer);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", employee=" + employee +
                ", customer=" + customer +
                '}';
    }
}
