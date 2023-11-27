package vn.edu.iuh.fit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String ADMIN = "ADMIN";
    private final String USER = "USER";

    /*
        Memory
     */
//    @Autowired
//    public void globalConfig(AuthenticationManagerBuilder auth, PasswordEncoder encoder) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser(
//                        User.withUsername("admin")
//                                .password(encoder.encode("admin"))
//                                .roles(ADMIN)
//                                .build()
//                )
//                .withUser(
//                        User.withUsername("user")
//                                .password(encoder.encode("user"))
//                                .roles(USER)
//                                .build()
//                );
//    }

    /*
        Database
     */
    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth,
                             PasswordEncoder encoder, @Qualifier("tempDataSource") DataSource dataSource) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .withDefaultSchema()
                .withUser(
                        User.withUsername("admin")
                                .password(encoder.encode("admin"))
                                .roles(ADMIN)
                                .build()
                )
                .withUser(
                        User.withUsername("teo")
                                .password(encoder.encode("teo"))
                                .roles(USER)
                                .build()
                );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.requestMatchers("/", "/home", "/index").permitAll()
                        .requestMatchers("/api/**").hasAnyRole(USER, ADMIN)
                        .requestMatchers("/admin/**").hasRole(ADMIN)
                        .anyRequest().authenticated()
        ).csrf(csrf->csrf.ignoringRequestMatchers("/h2-console/**"))
                        .headers(h->h.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
