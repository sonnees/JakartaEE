package vn.edu.iuh.fit.BackEnd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "candidate")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Candidate(LocalDate dob, String email, String fullName, String phone, Address address, List<Experiences> experiences, List<CandidateSkill> candidateSkills) {
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.experiences = experiences;
        this.candidateSkills = candidateSkills;
    }
}
