package vn.edu.iuh.fit.BackEnd.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.BackEnd.services.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateResource {
    private final CandidateService service;

    public CandidateResource(CandidateService service) {
        this.service = service;
    }
}
