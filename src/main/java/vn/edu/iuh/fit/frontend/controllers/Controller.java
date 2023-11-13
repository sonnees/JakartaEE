package vn.edu.iuh.fit.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

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
                             @RequestParam("password") String password,
                             RedirectAttributes redirectAttributes
                             ){

        if(name.isEmpty() || password.isEmpty()) return "redirect:/login";
        LocalDate localDate = LocalDate.now();
        redirectAttributes.addFlashAttribute("date", localDate);
        if(name.equals("admin")) return "redirect:/statistic/total-order-day-month";
        else if(name.equals("user")) return "redirect:/home/by";
        else return "redirect:/login";
    }

    @GetMapping("/check-out")
    public String checkOut(HttpSession httpSession){
        httpSession.removeAttribute("orderDetails");
        httpSession.removeAttribute("size");
        return "redirect:/login";
    }
}
