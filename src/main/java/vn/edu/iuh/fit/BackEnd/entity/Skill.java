package vn.edu.iuh.fit.BackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.BackEnd.enums.SkillType;

import java.util.List;

@Entity(name = "skill")
@Data @NoArgsConstructor @AllArgsConstructor
public class Skill {
    @Id
    private long id;
    private String skillName;
    private String skillDescription;

    @Enumerated
    private SkillType skillType;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;
}
