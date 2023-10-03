package vn.edu.iuh.fit.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepositories;

import javax.sql.DataSource;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepositories candidateRepositories;
    @Autowired
    public CandidateService(CandidateRepositories candidateRepositories) {
        this.candidateRepositories = candidateRepositories;
    }

    public List<Candidate> getAll(){return candidateRepositories.getAll();}
}
