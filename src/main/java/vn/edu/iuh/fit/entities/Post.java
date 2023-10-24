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
}
