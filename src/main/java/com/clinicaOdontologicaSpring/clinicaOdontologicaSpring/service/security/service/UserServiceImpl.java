package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.security.service;

import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity.User;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.repository.IUserRepository;
import com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.service.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usuarioBuscado = userRepository.findByUsername(username);

        if(usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        } else {
            throw new UsernameNotFoundException("El username ingresado no existe en la base de datos. Error.");
        }
    }
}
