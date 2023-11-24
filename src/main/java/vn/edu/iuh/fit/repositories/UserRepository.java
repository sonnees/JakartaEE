package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from user where email =:email", nativeQuery = true)
    User getUserByEmail(String email);

}