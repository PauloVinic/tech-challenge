package com.techchallenge.tech_challenge_backend.dto;

import com.techchallenge.tech_challenge_backend.model.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

public class UserDTOs {

    @Data
    public static class UserRequestDTO {
        @NotBlank
        private String nome;

        @Email
        @NotBlank
        private String email;

        @NotBlank
        private String login;

        @NotBlank
        private String senha;

        @NotBlank
        private String endereco;

        private TipoUsuario tipoUsuario;
    }

    @Data
    public static class UserResponseDTO {
        private Long id;
        private String nome;
        private String email;
        private String login;
        private String endereco;
        private LocalDateTime dataUltimaAlteracao;
        private TipoUsuario tipoUsuario;
    }

    @Data
    public static class LoginDTO {
        private String login;
        private String senha;
    }

    @Data
    public static class ChangePasswordDTO {
        private String login;
        private String oldPassword;
        private String newPassword;
    }
}
