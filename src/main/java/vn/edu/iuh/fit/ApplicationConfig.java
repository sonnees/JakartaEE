package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }

}
