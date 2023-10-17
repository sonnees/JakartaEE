package vn.edu.iuh.fit.BackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.edu.iuh.fit.BackEnd.entity.CandidateSkill;
import vn.edu.iuh.fit.BackEnd.ids.CandidateSkill_ID;

@RepositoryRestResource
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkill_ID> {
}