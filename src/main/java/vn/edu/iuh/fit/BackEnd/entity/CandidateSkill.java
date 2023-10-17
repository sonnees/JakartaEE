package vn.edu.iuh.fit.BackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.BackEnd.enums.SkillLevel;
import vn.edu.iuh.fit.BackEnd.ids.CandidateSkill_ID;

import java.util.Objects;

@Entity(name = "candidateSkill")
@IdClass(CandidateSkill_ID.class)
@Data @AllArgsConstructor @NoArgsConstructor
public class CandidateSkill {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Candidate candidate;

    @Id
    @ManyToOne
    private Skill skill;

    @Enumerated
    private SkillLevel skillLevel;

    private String moreInfo;

    public CandidateSkill(Candidate candidate, Skill skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkill that = (CandidateSkill) o;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }
}
