package vn.edu.iuh.fit.FrontEnd.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.BackEnd.entity.Candidate;
import vn.edu.iuh.fit.BackEnd.repositories.AddressRepository;
import vn.edu.iuh.fit.BackEnd.repositories.CandidateRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    CandidateRepository candidateRepository;
    private AddressRepository addressRepository;

    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @GetMapping("")
    public String getList(Model model){
        List<Candidate> candidates = candidateRepository.findAll();
        model.addAttribute("candidates", candidates);
        return "candidates/candidate";
    }

    @GetMapping("/page")
    public String getListPage(Model model,
        @RequestParam("page") Optional<Integer> page,
        @RequestParam("size") Optional<Integer> size){

        int curPage = page.orElse(1);
        int pageSize = size.orElse(7);

        Pageable pageable= PageRequest.of(
                curPage-1,
                pageSize,
                Sort.by(Sort.Direction.fromString("asc"),"id"));
        Page<Candidate> candidates_page = candidateRepository.findAll(pageable);
        model.addAttribute("candidates_page", candidates_page.stream().toList());

        List<Integer> totalPage = IntStream.range(1, candidates_page.getTotalPages()+1).boxed().collect(Collectors.toList());
        model.addAttribute("totalPage",totalPage );
        model.addAttribute("curPage",curPage);
        return "candidates/candidate_page";
    }

    @PostMapping ("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        candidateRepository.deleteById(id);

        System.out.println(candidateRepository.findById(0L).orElse(new Candidate()).getFullName());
        return "redirect:/candidates/page";
    }
}
