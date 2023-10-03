package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    private String email = null;
    @Id
    @Column(name = "comp_id")
    private UUID uuid =UUID.randomUUID();
    @Column(columnDefinition = "varchar(2000)")
    private String about = null;
    @Column(columnDefinition = "varchar(255)", name = "comp_name")
    private String compName = null;
    @Column(columnDefinition = "varchar(255)")
    private String phone = null;
    @Column(columnDefinition = "varchar(255)", name = "web_url")
    private String webUrl = null;
    @ManyToOne
    @JoinColumn(name = "address")
    private Address address =null;
}
