package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.security.utils;
/*
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.User;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.enums.ERole;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IUserRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;


public class CargaDatos implements ApplicationRunner {

    private IUserRepository userRepository;

    private IUserService userService;

    private IRoleService roleService;

    @Autowired
    public CargaDatos(IUserRepository userRepository, IUserService userService, IRoleService roleService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passToCryp1 = "a1b2c3d4e5f6g7h8i9j0";
        String cyptedPass1 = bCryptPasswordEncoder.encode(passToCryp1);
        Role adminRole1 = roleService.findByRoleName(ERole.ROLE_MODERATOR);
        Set<Role> roles1 = new HashSet<>();
        roles1.add(adminRole1);
        User user1 = userRepository.save(new User("efernandez", cyptedPass1, roles1));

        String passToCryp2 = "a1b2c3d4e5f6g7h8i9";
        String cyptedPass2 = bCryptPasswordEncoder.encode(passToCryp1);
        Role adminRole2 = roleService.findByRoleName(ERole.ROLE_ADMIN);
        Set<Role> roles2 = new HashSet<>();
        roles2.add(adminRole2);
        User user2 = userRepository.save(new User("jfarias", cyptedPass1, roles2));

        String passToCryp3 = "a1b2c3d4e5f6g7h8";
        String cyptedPass3 = bCryptPasswordEncoder.encode(passToCryp1);
        Role adminRole3 = roleService.findByRoleName(ERole.ROLE_USER);
        Set<Role> roles3 = new HashSet<>();
        roles3.add(adminRole3);
        User user3 = userRepository.save(new User("rsanchez", cyptedPass1, roles3));

    }
}
*/