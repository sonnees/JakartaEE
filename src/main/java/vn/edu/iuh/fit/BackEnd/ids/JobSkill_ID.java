package vn.edu.iuh.fit.BackEnd.ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.BackEnd.entity.Job;
import vn.edu.iuh.fit.BackEnd.entity.Skill;

import java.io.Serializable;
import java.util.Objects;

@Data @AllArgsConstructor @NoArgsConstructor
public class JobSkill_ID implements Serializable {
    private Job job;
    private Skill skill;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobSkill_ID that = (JobSkill_ID) o;
        return Objects.equals(job, that.job) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, skill);
    }
}
