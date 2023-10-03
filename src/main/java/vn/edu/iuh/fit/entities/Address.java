package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Address {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(columnDefinition = "varchar(150)")
    private String street= null;
    @Column(columnDefinition = "varchar(50)")
    private String city= null;
    @Column(columnDefinition = "smallint(6)")
    private Integer country = null;
    private String number= null;
    private String zipcode= null;
}
