package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.entities.User;
import vn.edu.iuh.fit.repositories.UserRepository;
import vn.edu.iuh.fit.services.UserService;
import vn.edu.iuh.fit.singleton.UserSingleton;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class MainController {
    UserRepository userRepository;
    UserService userService;
    UserSingleton userSingleton;

    @GetMapping("login")
    public String viewLogin(Model model){
        boolean ser = false;
        model.addAttribute("err", ser);
        return "login";
    }

    @PostMapping("check-login")
    public String checkLogin(Model model,
                             @RequestParam String gmail,
                             @RequestParam String password,
                             RedirectAttributes redirectAttributes
                             ){
        User user = userService.checkLogin(gmail, password);
        if(user==null){
            boolean ser = true;
            model.addAttribute("err", ser);
            return "login";
        }
        userSingleton.setUser(user);
        return "redirect:/home/kham-pha";
    }

}
