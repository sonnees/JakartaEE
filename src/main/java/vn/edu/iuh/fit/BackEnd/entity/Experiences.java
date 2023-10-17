package vn.edu.iuh.fit.BackEnd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "experiences")
@Data @NoArgsConstructor @AllArgsConstructor
public class Experiences {
    @Id
    private long id;
    private LocalDate toDate;
    private LocalDate fromDate;
    private String companyName;
    private String role;
    private String workDescription;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Candidate candidate;

}
