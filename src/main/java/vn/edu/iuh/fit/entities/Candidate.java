package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Candidate {
    @Id
    private UUID id =UUID.randomUUID();
    @Column(nullable = false,unique = true)
    private LocalDateTime dob;
    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String email;
    @Column(name = "full_name", columnDefinition = "varchar(255)", nullable = false)
    private  String fullName;
    @Column(columnDefinition = "varchar(15)", nullable = false)
    private  String phone;
    @ManyToOne()
    @JoinColumn(name = "address")
    private  Address address = null;

    public Candidate(LocalDateTime dob, String email, String fullName, String phone, Address address) {
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }
}
