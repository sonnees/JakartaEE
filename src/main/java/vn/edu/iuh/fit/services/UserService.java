package vn.edu.iuh.fit.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entities.User;
import vn.edu.iuh.fit.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public User checkLogin(String gmail, String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User userByEmail = userRepository.getUserByEmail(gmail);

        if(userByEmail==null) return null;

        boolean matches = bCryptPasswordEncoder.matches(password, userByEmail.getPasswordHash());
        if(matches)
            return userByEmail;
        return null;
    }
}
