package vn.edu.iuh.fit.controller.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class JdbcUserService {

    private DataSource dataSource;
    private JdbcUserDetailsManager manager;

    public UserDetails changePass(String name, String newPass){
        UserDetails userDetails = manager.loadUserByUsername(name);
        manager.changePassword("noop",newPass);
        return userDetails;
    }


}
