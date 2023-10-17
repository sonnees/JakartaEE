package vn.edu.iuh.fit.BackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.BackEnd.entity.Job;
import vn.edu.iuh.fit.BackEnd.entity.JobSkill;
import vn.edu.iuh.fit.BackEnd.entity.Skill;
import vn.edu.iuh.fit.BackEnd.ids.JobSkill_ID;
import vn.edu.iuh.fit.BackEnd.repositories.JobRepository;
import vn.edu.iuh.fit.BackEnd.repositories.JobSkillRepository;
import vn.edu.iuh.fit.BackEnd.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobSkillService {
    private final JobSkillRepository repository;
    private final JobRepository jobRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public JobSkillService(JobSkillRepository repository, JobRepository jobRepository, SkillRepository skillRepository) {
        this.repository = repository;
        this.jobRepository = jobRepository;
        this.skillRepository = skillRepository;
    }

}
