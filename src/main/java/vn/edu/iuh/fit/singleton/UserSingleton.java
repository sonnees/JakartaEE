package vn.edu.iuh.fit.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entities.User;

@Service
@NoArgsConstructor
@Getter
@Setter
public class UserSingleton {
    private User user;
}
