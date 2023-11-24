package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.entities.Post;
import vn.edu.iuh.fit.entities.PostComment;
import vn.edu.iuh.fit.repositories.PostCommentRepository;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.singleton.UserSingleton;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@RequestMapping("/comment")
public class PostCommentController {
    PostRepository  postRepository;
    PostCommentRepository postCommentRepository;
    UserSingleton userSingleton;

    @PostMapping("/add")
    public String viewDetail(Model model,
                             @RequestParam("id") Long id,
                             @RequestParam("content") String content
    )
    {
        PostComment postComment = new PostComment(
                "",1, LocalDate.now(),LocalDate.now(),content,
                postRepository.findById(id).get(),null,userSingleton.getUser()
        );

        postCommentRepository.save(postComment);

        Post post = postRepository.findById(id).get();
        model.addAttribute("status",1);
        model.addAttribute("post",post);
        return "detail";
    }

}
