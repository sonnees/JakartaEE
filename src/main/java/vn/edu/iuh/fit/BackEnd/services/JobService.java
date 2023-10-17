package vn.edu.iuh.fit.BackEnd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.BackEnd.entity.Job;
import vn.edu.iuh.fit.BackEnd.repositories.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

}
