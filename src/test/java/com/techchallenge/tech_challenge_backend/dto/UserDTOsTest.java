package com.techchallenge.tech_challenge_backend.dto;

import com.techchallenge.tech_challenge_backend.model.TipoUsuario;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserDTOsTest {

    @Test
    void testUserRequestDTO() {
        UserDTOs.UserRequestDTO dto = new UserDTOs.UserRequestDTO();
        dto.setNome("João");
        dto.setEmail("joao@email.com");
        dto.setLogin("joao123");
        dto.setSenha("senha123");
        dto.setEndereco("Rua A, 123");

        TipoUsuario tipo = new TipoUsuario();
        tipo.setId(1L);
        tipo.setNomeTipo("CLIENTE");
        dto.setTipoUsuario(tipo);

        assertEquals("João", dto.getNome());
        assertEquals("joao@email.com", dto.getEmail());
        assertEquals("joao123", dto.getLogin());
        assertEquals("senha123", dto.getSenha());
        assertEquals("Rua A, 123", dto.getEndereco());
        assertEquals("CLIENTE", dto.getTipoUsuario().getNomeTipo());
    }

    @Test
    void testUserResponseDTO() {
        UserDTOs.UserResponseDTO dto = new UserDTOs.UserResponseDTO();
        dto.setId(1L);
        dto.setNome("Maria");
        dto.setEmail("maria@email.com");
        dto.setLogin("maria123");
        dto.setEndereco("Rua B, 456");
        dto.setDataUltimaAlteracao(LocalDateTime.now());

        TipoUsuario tipo = new TipoUsuario();
        tipo.setId(2L);
        tipo.setNomeTipo("RESTAURANTE");
        dto.setTipoUsuario(tipo);

        assertEquals("Maria", dto.getNome());
        assertEquals("RESTAURANTE", dto.getTipoUsuario().getNomeTipo());
    }

    @Test
    void testLoginDTO() {
        UserDTOs.LoginDTO dto = new UserDTOs.LoginDTO();
        dto.setLogin("user");
        dto.setSenha("pass");

        assertEquals("user", dto.getLogin());
        assertEquals("pass", dto.getSenha());
    }

    @Test
    void testChangePasswordDTO() {
        UserDTOs.ChangePasswordDTO dto = new UserDTOs.ChangePasswordDTO();
        dto.setLogin("user");
        dto.setOldPassword("old");
        dto.setNewPassword("new");

        assertEquals("old", dto.getOldPassword());
        assertEquals("new", dto.getNewPassword());
    }
}
