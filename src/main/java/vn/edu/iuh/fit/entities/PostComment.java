package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "post_comment")
public class PostComment {
    @Id
    private long id;
    @Column(columnDefinition = "varchar(100)")
    private String title;
    @Column(columnDefinition = "tinyint(1)")
    private int published;
    private LocalDate createAt;
    private LocalDate publishAt;
    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    @OneToOne
    @JoinColumn(name = "parentID")
    private PostComment parentID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;
}
