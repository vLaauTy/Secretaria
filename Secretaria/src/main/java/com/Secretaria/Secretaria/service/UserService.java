package com.Secretaria.Secretaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.Secretaria.Secretaria.Model.UserModel;
import com.Secretaria.Secretaria.repository.UserRepository;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuario: " + username);
        UserModel usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        System.out.println("Usuario encontrado: " + usuario.getUsername());
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())));
    }

    public boolean autenticar(String username, String password) {
        UserModel usuario = userRepository.findByUsername(username).orElse(null);
        if (usuario == null) return false;
        if (usuario.isBloqueado()) return false;
        if (usuario.getPassword().equals(password)) {
            usuario.setIntentosFallidos(0);
            userRepository.save(usuario);
            return true;
        } else {
            usuario.setIntentosFallidos(usuario.getIntentosFallidos() + 1);
            if (usuario.getIntentosFallidos() >= 3) {
                usuario.setBloqueado(true);
            }
            userRepository.save(usuario);
            return false;
        }
    }

    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
