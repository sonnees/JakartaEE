package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.controller.service.JdbcUserService;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
@EnableMethodSecurity
public class AdminController {

    JdbcUserService jdbcUserService;

    @GetMapping()
    public String hello(){
        return "admin here";
    }

    @Secured("ADMIN")
    @PostMapping("/change-pass")
    public UserDetails changePass(
            Principal principal,
            @RequestBody String newPass

    ){
        System.out.println("newPass");
        return  jdbcUserService.changePass(principal.getName(), newPass);
    }
}
