package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import vn.edu.iuh.fit.entity.Skill;

@RepositoryRestResource
public interface SkillRepository extends JpaRepository<Skill, Long> {
}