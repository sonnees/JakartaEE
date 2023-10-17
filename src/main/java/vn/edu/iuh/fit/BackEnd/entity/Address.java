package vn.edu.iuh.fit.BackEnd.entity;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "address")
@Data @NoArgsConstructor @AllArgsConstructor
public class Address {
    @Id
    private long id;
    @Column(columnDefinition = "varchar(150)")
    private String street= null;
    @Column(columnDefinition = "varchar(50)")
    private String city= null;
    @Column(columnDefinition = "smallint(6)")
    private CountryCode country = null;
    @Column(columnDefinition = "varchar(20)")
    private String number= null;
    @Column(columnDefinition = "varchar(7)")
    private String zipcode= null;
}
