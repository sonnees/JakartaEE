package vn.edu.iuh.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@ToString
public class PostDTO {
    private long id;
    private String title;
    private String summary;
    private LocalDate creTime;
    private long idU;
    private String nameU;
}
