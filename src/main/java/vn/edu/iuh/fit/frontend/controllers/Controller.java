package vn.edu.iuh.fit.frontend.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/login")
    public String showViewLogin(Model model){
        model.addAttribute("name", "user");
        model.addAttribute("password", "password");
        return "login";
    }

    @GetMapping("/check-login")
    public String checkLogin(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("password") String password
                             ){

        if(name.isEmpty() || password.isEmpty()) return "redirect:/login";

        if(name.equals("admin")) return "login";
        else if(name.equals("user")) return "redirect:/product/by";
        else return "redirect:/login";
    }
}
