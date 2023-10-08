package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Experiences;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.repositories.ExperiencesRepository;
import vn.edu.iuh.fit.repositories.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

    public boolean add(Job job) {return repository.save(job).equals(job);}
    public boolean addAll(List<Job> list) {return repository.saveAll(list).equals(list);}
    public List<Job> getAll() {return (List<Job>) repository.findAll();}
    public Optional<Job> getByID(long id) {return repository.findById(id);}
    public void delete(long id) {repository.deleteById(id);}
}
