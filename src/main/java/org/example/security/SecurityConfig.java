package org.example.security;

import org.example.dao.UserRepository;
import org.example.dao.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // method name becomes the bean id (passwordEncoder)
        return new BCryptPasswordEncoder(); // returns a BCryptPasswordEncoder which will hash passwords securely
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            // Retrieve your custom entity
            User dbUser = userRepository.findByEmail(email);

            if (dbUser == null) {
                throw new UsernameNotFoundException("User not found with email: " + email);
            }

            // Return Spring Security's UserDetails implementation
            return org.springframework.security.core.userdetails.User.builder()
                    .username(dbUser.getEmail())
                    .password(dbUser.getPassword())
                    .roles(String.valueOf(dbUser.getRole()))
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints
                        .requestMatchers("/",
                                "/index",
                                "/register",
                                "/login",
                                "/css/**",
                                "/js/**",
                                "/h2-console/**")
                        .permitAll()

                        // Admin-only endpoints
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // User-only endpoints (Admins can be barred or granted access depending on policy)
                        .requestMatchers("/user/**").hasRole("USER")

                        // All other requests require authentication
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/user/books", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

}


