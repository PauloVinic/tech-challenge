package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.model.Restaurante;
import com.techchallenge.tech_challenge_backend.service.RestauranteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RestauranteControllerTest {

    @Mock
    private RestauranteService service;

    @InjectMocks
    private RestauranteController controller;
    
    @Test
    void deveCriarRestaurante() {
        Restaurante obj = new Restaurante();
        when(service.save(obj)).thenReturn(obj);

        Restaurante resultado = controller.create(obj);

        assertNotNull(resultado);
        verify(service).save(obj);
    }
    @Test
    void deveListarTodosOsRestaurantes() {
        when(service.findAll()).thenReturn(List.of(new Restaurante(), new Restaurante()));

        List<Restaurante> resultado = controller.getAll();

        assertEquals(2, resultado.size());
        verify(service).findAll();
    }
    @Test
    void deveBuscarRestaurantePorId() {
        Restaurante obj = new Restaurante();
        obj.setId(1L);
        when(service.findById(1L)).thenReturn(obj);

        Restaurante resultado = controller.getById(1L);

        assertEquals(1L, resultado.getId());
        verify(service).findById(1L);
    }
    @Test
    void deveDeletarRestaurantePorId() {
        controller.delete(1L);
        verify(service).deleteById(1L);
    }
}