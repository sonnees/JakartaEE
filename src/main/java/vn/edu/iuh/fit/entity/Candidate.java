package vn.edu.iuh.fit.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "candidate")
@Data @NoArgsConstructor @AllArgsConstructor
public class Candidate {
    @Id
    private long id;
    private LocalDate dob;
    private String email;
    private String fullName;
    private String phone;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Address address;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Experiences> experiences;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<CandidateSkill> candidateSkills;


}
