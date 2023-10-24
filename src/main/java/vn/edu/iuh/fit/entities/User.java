package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter  @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private long id;
    @Column(columnDefinition = "varchar(50)")
    private String firstName;
    @Column(columnDefinition = "varchar(50)")
    private String middleName;
    @Column(columnDefinition = "varchar(50)")
    private String lastName;
    @Column(columnDefinition = "varchar(15)")
    private String mobile;
    @Column(columnDefinition = "varchar(50)")
    private String email;
    @Column(columnDefinition = "varchar(64)")
    private String passwordHash;
    private LocalDate registeredAt;
    private LocalDate lastLogin;
    @Column(columnDefinition = "text")
    private String intro;
    @Column(columnDefinition = "text")
    private String profile;

    @OneToMany(mappedBy = "authorId")
    private List<Post> posts;

    @OneToMany(mappedBy = "userID")
    private List<PostComment> postComments;
 }
