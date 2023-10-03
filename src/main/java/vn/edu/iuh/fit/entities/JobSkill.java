package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "job_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobSkill {
    @Column(name = "more_infos", columnDefinition = "varchar(1000)")
    private String moreInfos=null;

    @Column(name = "skill_level", columnDefinition = "tinyint(4)")
    private Integer skillLevel=null;

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public JobSkill(Job job, Skill skill) {
        this.job = job;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkill jobSkill = (JobSkill) o;
        return Objects.equals(job, jobSkill.job) && Objects.equals(skill, jobSkill.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }
}
