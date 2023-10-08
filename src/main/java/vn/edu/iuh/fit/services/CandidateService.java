package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Address;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    public boolean add(Candidate candidate) {return candidateRepository.save(candidate).equals(candidate);}
    public boolean addAll(List<Candidate> candidates) {return candidateRepository.saveAll(candidates).equals(candidates);}
    public List<Candidate> getAll() {return (List<Candidate>) candidateRepository.findAll();}
    public Optional<Candidate> getByID(long id) {return candidateRepository.findById(id);}
    public void delete(long id) {candidateRepository.deleteById(id);}
}
