package vn.edu.iuh.fit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "demo-entity")
public class DemoEntity {
    @Id
    private long id;
    @Column(columnDefinition = "varchar(50)")
    private String name;
}
