package vn.edu.iuh.fit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import vn.edu.iuh.fit.dto.PostDTO;
import vn.edu.iuh.fit.entities.User;
import vn.edu.iuh.fit.mapping.PostDTOMapping;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.services.UserService;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostDTOMapping postDTOMapping;

    @Test
    void getUserByGmail() {
        User user = userService.checkLogin("Fadel@gmail.com", "123");
        System.out.println(user.getFirstName());
    }

    @Test
    void getAllPost() {
        Pageable pageable = PageRequest.of(0,5);
        Page<Object[]> all = postRepository.getAllDTO(pageable);
        List<PostDTO> postDTOS = postDTOMapping.to(all);
        postDTOS.forEach(i-> System.out.println(i.getTitle()));
    }

}
