package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.dto.UserDTOs.*;
import com.techchallenge.tech_challenge_backend.model.User;
import com.techchallenge.tech_challenge_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = fromDTO(dto);
        user.setSenha(passwordEncoder.encode(dto.getSenha()));
        user.setDataUltimaAlteracao(LocalDateTime.now());
        return toDTO(userRepository.save(user));
    }

    public Optional<UserResponseDTO> getUserByLogin(String login) {
        return userRepository.findByLogin(login).map(this::toDTO);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setLogin(dto.getLogin());
        user.setEndereco(dto.getEndereco());
        user.setTipoUsuario(dto.getTipoUsuario());
        user.setDataUltimaAlteracao(LocalDateTime.now());
        return toDTO(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean validateLogin(LoginDTO dto) {
        return userRepository.findByLogin(dto.getLogin())
                .map(user -> passwordEncoder.matches(dto.getSenha(), user.getSenha()))
                .orElse(false);
    }

    public boolean changePassword(ChangePasswordDTO dto) {
        return userRepository.findByLogin(dto.getLogin()).map(user -> {
            if (passwordEncoder.matches(dto.getOldPassword(), user.getSenha())) {
                user.setSenha(passwordEncoder.encode(dto.getNewPassword()));
                user.setDataUltimaAlteracao(LocalDateTime.now());
                userRepository.save(user);
                return true;
            }
            return false;
        }).orElse(false);
    }

    private User fromDTO(UserRequestDTO dto) {
        return User.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .login(dto.getLogin())
                .senha(dto.getSenha())
                .endereco(dto.getEndereco())
                .tipoUsuario(dto.getTipoUsuario())
                .build();
    }

    private UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        dto.setLogin(user.getLogin());
        dto.setEndereco(user.getEndereco());
        dto.setDataUltimaAlteracao(user.getDataUltimaAlteracao());
        dto.setTipoUsuario(user.getTipoUsuario());
        return dto;
    }
}
