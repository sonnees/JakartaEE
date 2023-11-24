package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(75)")
    private String title;
    @Column(columnDefinition = "varchar(100)")
    private String metaTitle;
    @Column(columnDefinition = "text")
    private String summary;
    @Column(columnDefinition = "tinyint(1)")
    private int published;
    private LocalDate createAt;
    private LocalDate updateAt;
    private LocalDate publishedAt;
    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User authorId;

    @OneToOne
    @JoinColumn(name = "parentID")
    private Post parentID;

    @OneToMany(mappedBy = "postId")
    private List<PostComment> postComments;

    public Post(String title, String metaTitle, String summary, int published, LocalDate createAt, LocalDate updateAt, LocalDate publishedAt, String content, User authorId, Post parentID, List<PostComment> postComments) {
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.authorId = authorId;
        this.parentID = parentID;
        this.postComments = postComments;
    }
}
