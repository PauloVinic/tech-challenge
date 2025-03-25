package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.model.TipoUsuario;
import com.techchallenge.tech_challenge_backend.service.TipoUsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TipoUsuarioControllerTest {

    @Mock
    private TipoUsuarioService service;

    @InjectMocks
    private TipoUsuarioController controller;
    
    @Test
    void deveCriarTipoUsuario() {
        TipoUsuario obj = new TipoUsuario();
        when(service.save(obj)).thenReturn(obj);

        TipoUsuario resultado = controller.create(obj);

        assertNotNull(resultado);
        verify(service).save(obj);
    }
    @Test
    void deveListarTodosOsTipoUsuarios() {
        when(service.findAll()).thenReturn(List.of(new TipoUsuario(), new TipoUsuario()));

        List<TipoUsuario> resultado = controller.getAll();

        assertEquals(2, resultado.size());
        verify(service).findAll();
    }
    @Test
    void deveBuscarTipoUsuarioPorId() {
        TipoUsuario obj = new TipoUsuario();
        obj.setId(1L);
        when(service.findById(1L)).thenReturn(obj);

        TipoUsuario resultado = controller.getById(1L);

        assertEquals(1L, resultado.getId());
        verify(service).findById(1L);
    }
    @Test
    void deveDeletarTipoUsuarioPorId() {
        controller.delete(1L);
        verify(service).deleteById(1L);
    }
}