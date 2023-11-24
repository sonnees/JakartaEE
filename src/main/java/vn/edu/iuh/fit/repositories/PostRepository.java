package vn.edu.iuh.fit.repositories;

import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select p.id, p.title, p.summary, p.create_at,u.id, u.middle_name from post p " +
            "left join lab05.user u on p.author_id = u.id " +
            "where published = 1 " +
            "order by create_at desc ", nativeQuery = true)
    Page<Object[]> getAllDTO(Pageable pageable);

    @Query(value = "select p.id, p.title, p.summary, p.create_at,u.id, u.middle_name from post p " +
            "left join lab05.user u on p.author_id = u.id " +
            "where u.id = :id " +
            "order by create_at desc ", nativeQuery = true)
    List<Object[]> getByID(Long id);

}