
package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.dto.UserDTOs.*;
import com.techchallenge.tech_challenge_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void deveCriarUsuario() {
        UserRequestDTO dto = new UserRequestDTO();
        UserResponseDTO response = new UserResponseDTO();
        when(userService.createUser(dto)).thenReturn(response);

        ResponseEntity<UserResponseDTO> result = userController.createUser(dto);

        assertEquals(response, result.getBody());
        verify(userService).createUser(dto);
    }

    @Test
    void deveBuscarUsuarioPorLogin() {
        String login = "usuario123";
        UserResponseDTO response = new UserResponseDTO();
        when(userService.getUserByLogin(login)).thenReturn(Optional.of(response));

        ResponseEntity<UserResponseDTO> result = userController.getUserByLogin(login);

        assertEquals(response, result.getBody());
        verify(userService).getUserByLogin(login);
    }

    @Test
    void deveAtualizarUsuario() {
        Long id = 1L;
        UserRequestDTO dto = new UserRequestDTO();
        UserResponseDTO response = new UserResponseDTO();
        when(userService.updateUser(id, dto)).thenReturn(response);

        ResponseEntity<UserResponseDTO> result = userController.updateUser(id, dto);

        assertEquals(response, result.getBody());
        verify(userService).updateUser(id, dto);
    }

    @Test
    void deveDeletarUsuario() {
        Long id = 1L;

        ResponseEntity<Void> result = userController.deleteUser(id);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(userService).deleteUser(id);
    }

    @Test
    void deveValidarLogin() {
        LoginDTO loginDTO = new LoginDTO();
        when(userService.validateLogin(loginDTO)).thenReturn(true);

        ResponseEntity<Boolean> result = userController.validateLogin(loginDTO);

        assertTrue(Boolean.TRUE.equals(result.getBody()));
        verify(userService).validateLogin(loginDTO);
    }

    @Test
    void deveTrocarSenha() {
        ChangePasswordDTO dto = new ChangePasswordDTO();
        when(userService.changePassword(dto)).thenReturn(true); // mocka retorno esperado
    
        ResponseEntity<Boolean> result = userController.changePassword(dto);
    
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(Boolean.TRUE.equals(result.getBody()));
        verify(userService).changePassword(dto);
    }
}
