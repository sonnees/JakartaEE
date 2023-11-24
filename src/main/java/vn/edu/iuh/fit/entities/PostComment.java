package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "post_comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public PostComment(String title, int published, LocalDate createAt, LocalDate publishAt, String content, Post postId, PostComment parentID, User userID) {
        this.title = title;
        this.published = published;
        this.createAt = createAt;
        this.publishAt = publishAt;
        this.content = content;
        this.postId = postId;
        this.parentID = parentID;
        this.userID = userID;
    }
}
