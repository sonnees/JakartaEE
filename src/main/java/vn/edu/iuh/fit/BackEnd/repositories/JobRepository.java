package vn.edu.iuh.fit.BackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.edu.iuh.fit.BackEnd.entity.Job;

@RepositoryRestResource
public interface JobRepository extends JpaRepository<Job, Long> {
}