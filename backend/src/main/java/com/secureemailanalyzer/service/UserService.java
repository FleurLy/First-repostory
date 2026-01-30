package com.secureemailanalyzer.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.secureemailanalyzer.model.UserEntity;
import com.secureemailanalyzer.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordStrengthService passwordStrengthService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, PasswordStrengthService passwordStrengthService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordStrengthService = passwordStrengthService;
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    // public void registerUser(String username, String rawPassword) {
    //     UserEntity user = new UserEntity();
    //     user.setUsername(username);
    //     user.setPassword(passwordEncoder.encode(rawPassword));
    //     user.setRole("ROLE_USER");

    //     userRepository.save(user);
    // }

    public void registerUser(String username, String rawPassword) {
    if (!passwordStrengthService.isStrong(rawPassword)) {
        throw new IllegalArgumentException("Weak password");
    }

    UserEntity user = new UserEntity();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(rawPassword));
    user.setRole("ROLE_USER");

    userRepository.save(user);
}

}
