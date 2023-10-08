package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.CandidateSkill;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.ids.CandidateSkill_ID;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateSkillService {
    CandidateSkillRepository repository;
    CandidateRepository candidateRepository;
    SkillRepository skillRepository;

    @Autowired
    public CandidateSkillService(CandidateSkillRepository repository, CandidateRepository candidateRepository, SkillRepository skillRepository) {
        this.repository = repository;
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
    }

    public boolean add(CandidateSkill candidateSkill) {return repository.save(candidateSkill).equals(candidateSkill);}
    public boolean addAll(List<CandidateSkill> list) {return repository.saveAll(list).equals(list);}
    public List<CandidateSkill> getAll() {return (List<CandidateSkill>) repository.findAll();}
    public Optional<CandidateSkill> getByID(long id_candidate,long id_skill ) {
        return repository.findById(new CandidateSkill_ID(
                candidateRepository.findById(id_candidate).orElse(new Candidate()),
                skillRepository.findById(id_skill).orElse(new Skill())
        ));
    }
    public void delete(long id_candidate,long id_skill ) {repository.deleteById(new CandidateSkill_ID(
            candidateRepository.findById(id_candidate).orElse(new Candidate()),
            skillRepository.findById(id_skill).orElse(new Skill())
    ));}
}
