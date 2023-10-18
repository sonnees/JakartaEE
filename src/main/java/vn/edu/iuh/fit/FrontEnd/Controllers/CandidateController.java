package vn.edu.iuh.fit.FrontEnd.Controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.BackEnd.entity.Address;
import vn.edu.iuh.fit.BackEnd.entity.Candidate;
import vn.edu.iuh.fit.BackEnd.repositories.AddressRepository;
import vn.edu.iuh.fit.BackEnd.repositories.CandidateRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    CandidateRepository candidateRepository;
    AddressRepository addressRepository;

    public CandidateController(CandidateRepository candidateRepository, AddressRepository addressRepository) {
        this.candidateRepository = candidateRepository;
        this.addressRepository = addressRepository;
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

    @GetMapping("/form-add")
    public String getFormAdd(Model model){
        List<CountryCode> listCountryCodes = Arrays.stream(CountryCode.values()).toList();
        model.addAttribute("listCountryCodes", listCountryCodes);
        return "candidates/add";
    }
    @GetMapping("/form-update/{id}")
    public String getFormUpdate(Model model,
        @PathVariable("id") long id
    ){
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if(candidate==null) return "candidates/candidate_page";
        model.addAttribute("candidate",candidate);

        List<CountryCode> listCountryCodes = Arrays.stream(CountryCode.values()).toList();
        model.addAttribute("listCountryCodes", listCountryCodes);

        return "candidates/update";
    }

    @PostMapping ("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        candidateRepository.deleteById(id);

        System.out.println(candidateRepository.findById(0L).orElse(new Candidate()).getFullName());
        return "redirect:/candidates/page";
    }

    @PostMapping ("/add")
    public String delete(
            @RequestParam("fullName") String fullName,
            @RequestParam("email") String email,
            @RequestParam("dob") LocalDate dob,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address
    ){
        Address add = new Address(CountryCode.getByCode(address));
        addressRepository.save(add);
        Candidate candidate = new Candidate(
                dob, email, fullName, phone,
                add,
                new ArrayList<>(),
                new ArrayList<>()
        );
        candidateRepository.save(candidate);

        return "redirect:/candidates/page";
    }

    @PostMapping ("/update")
    public String update(
            @RequestParam("fullName") String fullName,
            @RequestParam("id") String id,
            @RequestParam("idAdd") String idAdd,
            @RequestParam("email") String email,
            @RequestParam("dob") LocalDate dob,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address
    ){
        Address add = addressRepository.findById(Long.parseLong(idAdd)).orElse(new Address());
        add.setCountry(CountryCode.getByCode(address));
        addressRepository.save(add);

        Candidate candidate = new Candidate(
                Long.parseLong(id),
                dob, email, fullName, phone,
                add,
                new ArrayList<>(),
                new ArrayList<>()
        );
        candidateRepository.save(candidate);

        return "redirect:/candidates/page";
    }
}
