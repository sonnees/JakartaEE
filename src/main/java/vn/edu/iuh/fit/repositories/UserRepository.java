package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}