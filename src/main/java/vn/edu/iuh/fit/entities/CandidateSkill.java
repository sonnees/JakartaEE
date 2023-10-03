package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "candidate_skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CandidateSkill {
    @Column(name = "more_infos", columnDefinition = "varchar(2000)")
    private String more_infos = null;

    @Column(name = "skill_level", columnDefinition = "tinyint(4)", nullable = false)
    private Integer skillLevel =null;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public CandidateSkill(Skill skill, Candidate candidate) {
        this.skill = skill;
        this.candidate = candidate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkill that = (CandidateSkill) o;
        return Objects.equals(skill, that.skill) && Objects.equals(candidate, that.candidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, candidate);
    }
}
