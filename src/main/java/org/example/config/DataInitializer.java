package org.example.config;

import org.example.dao.UserRepository;
import org.example.dao.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if admin user already exists
            if (userRepository.findByEmail("admin") == null) {
                User admin = new User();
                admin.setEmail("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRole(User.Role.ADMIN);

                userRepository.save(admin);
                System.out.println(">>> Default Admin User Created: admin / admin");
            }
        };
    }
}