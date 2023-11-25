package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import vn.edu.iuh.fit.entities.Post;
import vn.edu.iuh.fit.entities.PostComment;
import vn.edu.iuh.fit.entities.User;
import vn.edu.iuh.fit.repositories.PostCommentRepository;
import vn.edu.iuh.fit.repositories.PostRepository;
import vn.edu.iuh.fit.repositories.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@SpringBootTest
class InsertDataTest {
    Faker faker = new Faker();

    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostCommentRepository postCommentRepository;

    @Test
    void add() {
        addUser();
        addPost();
        addPostComment();
    }

    private void addPostComment() {
        PostComment postComment= null;

        for (int i = 1; i<= 20; i++){
            for (int j = 1; j<= 3; j++){
                postComment = new PostComment(
                        faker.artist().name(),
                        1,
                        LocalDate.now(),
                        LocalDate.now(),
                        faker.artist().name(),
                        postRepository.findById(Long.parseLong(i+"")).get(),
                        null,
                       userRepository.findById(faker.random().nextLong(1,20)).get()
                );
                postCommentRepository.save(postComment);
            }
        }

//        for (int i = 1; i<= 10; i++){
//            postComment = new PostComment(
//                    faker.artist().name(),
//                    1,
//                    LocalDate.now(),
//                    LocalDate.now(),
//                    faker.artist().name(),
//                    postRepository.findById(Long.parseLong(i+"")).get(),
//                    postCommentRepository.findById(Long.parseLong(i+"")).get(),
//                    userRepository.findById(faker.random().nextLong(1,20)).get()
//                    );
//            postCommentRepository.save(postComment);
//            }
    }

    void addPost(){
        Random random = new Random();
        Post post = null;
        for (int i = 1; i<= 20; i++){
            for (int j = 1; j<= 1; j++){
                post = new Post(
                        faker.pokemon().name(),
                        faker.pokemon().move(),
                        faker.address().fullAddress(),
                        1,
                        LocalDate.of(2023,
                                faker.random().nextInt(1,11),
                                faker.random().nextInt(1,25)
                                ),
                        LocalDate.now(),
                        LocalDate.now(),
                        faker.address().secondaryAddress(),
                        userRepository.findById(Long.parseLong(i+"")).get(),
                        null,
                        new ArrayList<>()
                );
                postRepository.save(post);
            }
        }
    }

    void addUser(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = null;
        for (int i = 1; i<= 20; i++){
            user = new User(
                    faker.name().firstName(), faker.name().nameWithMiddle(), faker.name().lastName(),
                    faker.phoneNumber().cellPhone(), "%s@gmail.com".formatted(faker.name().lastName()),
                    bCryptPasswordEncoder.encode("123"), LocalDate.now(),LocalDate.now(),
                    faker.name().title(),faker.name().title(), new ArrayList<>(),new ArrayList<>()
            );
            userRepository.save(user);
        }
    }
}
