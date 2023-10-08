package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}