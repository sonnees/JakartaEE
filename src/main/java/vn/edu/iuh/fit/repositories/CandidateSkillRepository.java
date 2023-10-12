package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.CandidateSkill;
import vn.edu.iuh.fit.ids.CandidateSkill_ID;

@RepositoryRestResource
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkill_ID> {
}