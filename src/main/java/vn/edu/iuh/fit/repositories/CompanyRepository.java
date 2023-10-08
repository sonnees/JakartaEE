package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}