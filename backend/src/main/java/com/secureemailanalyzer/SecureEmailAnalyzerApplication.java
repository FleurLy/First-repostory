package com.secureemailanalyzer;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.secureemailanalyzer.model.UserEntity;
// import com.secureemailanalyzer.repository.UserRepository;

@SpringBootApplication
public class SecureEmailAnalyzerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecureEmailAnalyzerApplication.class, args);
    }

    // utilisateur de test (à supprimer en production)
    // @Bean
    // CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
    //     return args -> {
    //             UserEntity user = new UserEntity();
    //             user.setUsername("fatima");
    //             user.setPassword(encoder.encode("1234"));
    //             user.setRole("ROLE_USER");
    //             repo.save(user);
    //     };
    // }

}
