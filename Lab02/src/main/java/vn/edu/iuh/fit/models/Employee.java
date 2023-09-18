package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "bigint(20)")
    private Long id;

    @Column(name = "address", columnDefinition = "varchar(250)")
    private String address;

    @Column(name = "dob", columnDefinition = "datetime(6)")
    private LocalDateTime dob;
    @Column(name = "email", columnDefinition = "varchar(150)")
    private String email;
    @Column(name = "full_name", columnDefinition = "varchar(150)")
    private String fullName;
    @Column(name = "phone", columnDefinition = "varchar(15)")
    private String phone;
    @Column(name = "status", columnDefinition = "int(11)")
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(Long id, String address, LocalDateTime dob, String email, String fullName, String phone, EmployeeStatus status) {
        this.id = id;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public Employee(String address, LocalDateTime dob, String email, String fullName, String phone, EmployeeStatus status) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
