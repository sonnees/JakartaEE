package vn.edu.iuh.fit.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @GetMapping()
    public String hello(){
        return "api here";
    }

}
