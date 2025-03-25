package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.model.TipoUsuario;
import com.techchallenge.tech_challenge_backend.repository.TipoUsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TipoUsuarioServiceTest {

    @Mock
    private TipoUsuarioRepository repository;

    @InjectMocks
    private TipoUsuarioService service;

    @Test
    void deveSalvarTipoUsuario() {
        TipoUsuario obj = new TipoUsuario();
        when(repository.save(obj)).thenReturn(obj);

        TipoUsuario resultado = service.save(obj);

        assertEquals(obj, resultado);
        verify(repository).save(obj);
    }

    @Test
    void deveBuscarTodosOsTipoUsuarios() {
        when(repository.findAll()).thenReturn(Arrays.asList(new TipoUsuario(), new TipoUsuario()));

        List<TipoUsuario> resultado = service.findAll();

        assertEquals(2, resultado.size());
        verify(repository).findAll();
    }

    @Test
    void deveBuscarTipoUsuarioPorId() {
        TipoUsuario obj = new TipoUsuario();
        obj.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(obj));

        TipoUsuario resultado = service.findById(1L);

        assertEquals(1L, resultado.getId());
        verify(repository).findById(1L);
    }

    @Test
    void deveDeletarTipoUsuarioPorId() {
        Long id = 1L;
        service.deleteById(id);
        verify(repository).deleteById(id);
    }
}