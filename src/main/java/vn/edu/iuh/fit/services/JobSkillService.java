package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.ids.JobSkill_ID;
import vn.edu.iuh.fit.repositories.JobRepository;
import vn.edu.iuh.fit.repositories.JobSkillRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

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

    public boolean add(JobSkill jobSkill) {return repository.save(jobSkill).equals(jobSkill);}
    public boolean addAll(List<JobSkill> list) {return repository.saveAll(list).equals(list);}
    public List<JobSkill> getAll() {return (List<JobSkill>) repository.findAll();}
    public Optional<JobSkill> getByID(long id_job, long id_skill) {
        return repository.findById(
                new JobSkill_ID(
                        jobRepository.findById(id_job).orElse(new Job()),
                        skillRepository.findById(id_skill).orElse(new Skill())
                )
        );
    }
    public void delete(long id_job, long id_skill) {repository.deleteById(
            new JobSkill_ID(
            jobRepository.findById(id_job).orElse(new Job()),
            skillRepository.findById(id_skill).orElse(new Skill())
            )
        );
    }
}
