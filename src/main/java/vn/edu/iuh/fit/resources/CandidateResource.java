package vn.edu.iuh.fit.resources;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.services.CandidateService;

@Resource
public class CandidateResource {
    @Autowired
    private CandidateService service;


}
