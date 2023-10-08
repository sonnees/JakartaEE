package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Company;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.repositories.CompanyRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    @Autowired
    SkillRepository repository;

    public boolean add(Skill skill) {return repository.save(skill).equals(skill);}
    public boolean addAll(List<Skill> list) {return repository.saveAll(list).equals(list);}
    public List<Skill> getAll() {return (List<Skill>) repository.findAll();}
    public Optional<Skill> getByID(long id) {return repository.findById(id);}
    public void delete(long id) {repository.deleteById(id);}
}
