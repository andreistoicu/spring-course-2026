package org.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean // exposes a PasswordEncoder as a Spring bean
    public PasswordEncoder passwordEncoder() { // method name becomes the bean id (passwordEncoder)
        return new BCryptPasswordEncoder(); // returns a BCryptPasswordEncoder which will hash passwords securely
    }

    @Bean
    public UserDetailsService userDetailService(){
        // Build a simple user with username "user"
        UserDetails user = User.builder() // start building a UserDetails object using Spring's User builder
                .username("user") // set username to "user"
                .password(passwordEncoder().encode("pass")) // set password (hashed using the PasswordEncoder bean)
                .roles("USER") // assign role(s) to the user, here "USER" (Spring will prefix with "ROLE_" internally)
                .build(); // finalize the UserDetails object

        // Return an InMemoryUserDetailsManager initialized with the two users above
        return new InMemoryUserDetailsManager(user); // in-memory
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // allow H2 console iframes
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/error/**", "/login", "/login/**", "/h2-console", "/h2-console/**").permitAll()
                        //.requestMatchers("/accounts/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .permitAll()
                ) //use the default login page provided by Spring Security
                .logout(logout -> logout
                        .permitAll()
                ) //Allow anyoane to logout
        ;

        return http.build();
    }

}
