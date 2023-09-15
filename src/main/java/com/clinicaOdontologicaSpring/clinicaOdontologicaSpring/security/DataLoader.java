package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.security;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.User;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.enums.ERole;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String hashUsuario = passwordEncoder.encode("user");
        User user = new User("user", hashUsuario, ERole.ROLE_USER);

        String hashAdmin = passwordEncoder.encode("admin");
        User userAdmin = new User("admin", hashAdmin, ERole.ROLE_ADMIN);

        String hashModerator = passwordEncoder.encode("moderator");
        User userModerator = new User("moderator", hashModerator, ERole.ROLE_MODERATOR);

        userRepository.save(user);
        userRepository.save(userAdmin);
        userRepository.save(userModerator);

    }
}
