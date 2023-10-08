package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "job")
@Data @AllArgsConstructor @NoArgsConstructor
public class Job {
    @Id
    private long id;
    private String name;
    private String description;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "job")
    private List<JobSkill> jobSkills;
}
