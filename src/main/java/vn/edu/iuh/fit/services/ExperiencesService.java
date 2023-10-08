package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.Company;
import vn.edu.iuh.fit.entity.Experiences;
import vn.edu.iuh.fit.repositories.CompanyRepository;
import vn.edu.iuh.fit.repositories.ExperiencesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperiencesService {
    @Autowired
    ExperiencesRepository repository;

    public boolean add(Experiences experiences) {return repository.save(experiences).equals(experiences);}
    public boolean addAll(List<Experiences> list) {return repository.saveAll(list).equals(list);}
    public List<Experiences> getAll() {return (List<Experiences>) repository.findAll();}
    public Optional<Experiences> getByID(long id) {return repository.findById(id);}
    public void delete(long id) {repository.deleteById(id);}
}
