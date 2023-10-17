package vn.edu.iuh.fit.BackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.BackEnd.entity.Experiences;
import vn.edu.iuh.fit.BackEnd.repositories.ExperiencesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperiencesService {
    @Autowired
    ExperiencesRepository repository;

}
