package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MeuUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MeuUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.techchallenge.tech_challenge_backend.model.User user = userRepository.findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            return org.springframework.security.core.userdetails.User.builder()
            .username(user.getLogin())
            .password(user.getSenha())
            .roles("ADMIN") // ou user.getTipoUsuario().getNomeTipo().toUpperCase()
            .build();
    }
}
