package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity(name = "job")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
    @Id
    @Column(name = "job_id")
    private UUID id=UUID.randomUUID();
    @Column(name = "job_desc", columnDefinition = "varchar(2000)")
    private String jobDesc=null;
    @Column(name = "job_name", columnDefinition = "varchar(255)")
    private String jobName = null;
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company = null;
}
