package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.entities.Post;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.services.PostService;
import vn.edu.iuh.fit.singleton.UserSingleton;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    PostRepository postRepository;
    PostService postService;
    UserSingleton userSingleton;

    @GetMapping("/add")
    public String viewFormAdd(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        model.addAttribute("status",2);
        return "addPost";
    }

    @PostMapping("/add")
    public String add(Model model,
                      @ModelAttribute("post") Post post
                      ){
        if(userSingleton==null)
            return "login";

        post.setAuthorId(userSingleton.getUser());
        post.setPostComments(new ArrayList<>());
        post.setCreateAt(LocalDate.now());
        post.setMetaTitle("");
        post.setUpdateAt(LocalDate.now());

        postRepository.save(post);

        return "redirect:/home/profile";
    }
}
