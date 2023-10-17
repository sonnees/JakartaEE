package vn.edu.iuh.fit.BackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.BackEnd.entity.Candidate;
import vn.edu.iuh.fit.BackEnd.entity.CandidateSkill;
import vn.edu.iuh.fit.BackEnd.entity.Skill;
import vn.edu.iuh.fit.BackEnd.ids.CandidateSkill_ID;
import vn.edu.iuh.fit.BackEnd.repositories.CandidateRepository;
import vn.edu.iuh.fit.BackEnd.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.BackEnd.repositories.SkillRepository;

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

}
