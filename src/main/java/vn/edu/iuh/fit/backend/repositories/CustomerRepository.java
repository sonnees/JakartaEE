package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}