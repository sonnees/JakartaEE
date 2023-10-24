package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.entities.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}