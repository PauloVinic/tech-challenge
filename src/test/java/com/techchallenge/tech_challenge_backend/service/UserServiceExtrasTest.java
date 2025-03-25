
package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.dto.UserDTOs.*;
import com.techchallenge.tech_challenge_backend.model.User;
import com.techchallenge.tech_challenge_backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceExtrasTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExisteAoAtualizar() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> userService.updateUser(1L, new UserRequestDTO()));
    }
    @Test
    void deveLancarExcecaoQuandoUsuarioNaoExisteAoDeletar() {
        doThrow(new RuntimeException("Usuário não encontrado"))
            .when(userRepository).deleteById(1L);
    
        assertThrows(RuntimeException.class, () -> userService.deleteUser(1L));
    }

    @Test
    void deveValidarLoginInvalido() {
        LoginDTO dto = new LoginDTO();
        dto.setLogin("user");
        dto.setSenha("senha");
        when(userRepository.findByLogin("user")).thenReturn(Optional.empty());

        boolean valido = userService.validateLogin(dto);
        assertFalse(valido);
    }

    @Test
    void deveValidarLoginComSenhaIncorreta() {
        LoginDTO dto = new LoginDTO();
        dto.setLogin("user");
        dto.setSenha("senhaErrada");
        User user = new User();
        user.setSenha("senhaCriptografada");

        when(userRepository.findByLogin("user")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("senhaErrada", "senhaCriptografada")).thenReturn(false);

        boolean valido = userService.validateLogin(dto);
        assertFalse(valido);
    }

    @Test
    void deveValidarLoginComSucesso() {
        LoginDTO dto = new LoginDTO();
        dto.setLogin("user");
        dto.setSenha("senha");
        User user = new User();
        user.setSenha("senhaCriptografada");

        when(userRepository.findByLogin("user")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("senha", "senhaCriptografada")).thenReturn(true);

        boolean valido = userService.validateLogin(dto);
        assertTrue(valido);
    }

    @Test
        void deveTrocarSenhaComSucesso() {
        ChangePasswordDTO dto = new ChangePasswordDTO();
        dto.setLogin("user");
        dto.setOldPassword("senhaAntiga");
        dto.setNewPassword("senhaNova");

        User user = new User();
        user.setSenha("senhaCriptografada");

        when(userRepository.findByLogin("user")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("senhaAntiga", "senhaCriptografada")).thenReturn(true);
        when(passwordEncoder.encode("senhaNova")).thenReturn("senhaNovaCriptografada");

        boolean resultado = userService.changePassword(dto);

        assertTrue(resultado);
        verify(userRepository).save(user);
        assertEquals("senhaNovaCriptografada", user.getSenha());
}
}
