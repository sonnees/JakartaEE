package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.PostDTO;
import vn.edu.iuh.fit.entities.Post;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.services.PostService;
import vn.edu.iuh.fit.singleton.PostsSingleton;
import vn.edu.iuh.fit.singleton.UserSingleton;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {
    PostsSingleton postsSingleton;
    PostService postService;
    PostRepository postRepository;
    UserSingleton userSingleton;


    @GetMapping("/kham-pha")
    public String viewLHome(Model model,
                            @RequestParam Optional<Integer> page
                            )
    {
        if(userSingleton==null)
            return "login";

        if(!postsSingleton.getPostDTOS().isEmpty() && page.orElse(0)==0)
            page = Optional.of(postsSingleton.getPostDTOS().size() / 5);
        else {
            Pageable pageable = PageRequest.of(page.orElse(0),5);
            List<PostDTO> allDTO = postService.getAllDTO(pageable);
            postsSingleton.setPostDTOS(allDTO);
        }
        model.addAttribute("page",page.orElse(0)+1);
        model.addAttribute("status",1);
        model.addAttribute("listPost", postsSingleton.getPostDTOS());
        return "home";
    }

    @GetMapping("/kham-pha-new")
    public String viewLHomeNew(Model model,
                            @RequestParam Optional<Integer> page
    )
    {
        if(userSingleton==null)
            return "login";

        page = Optional.of(0);
        System.out.println(page);
        Pageable pageable = PageRequest.of(0,5);
        List<PostDTO> allDTO = postService.getAllDTO(pageable);
        postsSingleton.reSet();
        postsSingleton.setPostDTOS(allDTO);

        model.addAttribute("page", 1);
        model.addAttribute("status",1);
        model.addAttribute("listPost", postsSingleton.getPostDTOS());
        return "home";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model
    )
    {
        if(userSingleton==null)
            return "login";

        List<PostDTO> listPost = postService.getByID(userSingleton.getUser().getId());

        model.addAttribute("status",3);
        model.addAttribute("listPost", listPost);
        return "profile";
    }

    @GetMapping("/lock-out")
    public String lockOut()
    {
        userSingleton.setUser(null);

        return "login";
    }

    @PostMapping("/kham-pha/detail/{id}")
    public String viewDetail(Model model,
                            @PathVariable("id") Long id
    )
    {
        if(userSingleton==null)
            return "login";

        Post post = postRepository.findById(id).get();
        model.addAttribute("status",1);
        model.addAttribute("post",post);
        return "detail";
    }

}
