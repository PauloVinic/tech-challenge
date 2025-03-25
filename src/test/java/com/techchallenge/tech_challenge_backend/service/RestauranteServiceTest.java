package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.model.Restaurante;
import com.techchallenge.tech_challenge_backend.repository.RestauranteRepository;
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
public class RestauranteServiceTest {

    @Mock
    private RestauranteRepository repository;

    @InjectMocks
    private RestauranteService service;

    @Test
    void deveSalvarRestaurante() {
        Restaurante obj = new Restaurante();
        when(repository.save(obj)).thenReturn(obj);

        Restaurante resultado = service.save(obj);

        assertEquals(obj, resultado);
        verify(repository).save(obj);
    }

    @Test
    void deveBuscarTodosOsRestaurantes() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Restaurante(), new Restaurante()));

        List<Restaurante> resultado = service.findAll();

        assertEquals(2, resultado.size());
        verify(repository).findAll();
    }

    @Test
    void deveBuscarRestaurantePorId() {
        Restaurante obj = new Restaurante();
        obj.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(obj));

        Restaurante resultado = service.findById(1L);

        assertEquals(1L, resultado.getId());
        verify(repository).findById(1L);
    }

    @Test
    void deveDeletarRestaurantePorId() {
        Long id = 1L;
        service.deleteById(id);
        verify(repository).deleteById(id);
    }
}