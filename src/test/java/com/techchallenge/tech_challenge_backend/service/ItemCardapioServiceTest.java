package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.model.ItemCardapio;
import com.techchallenge.tech_challenge_backend.repository.ItemCardapioRepository;
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
public class ItemCardapioServiceTest {

    @Mock
    private ItemCardapioRepository repository;

    @InjectMocks
    private ItemCardapioService service;

    @Test
    void deveSalvarItemCardapio() {
        ItemCardapio obj = new ItemCardapio();
        when(repository.save(obj)).thenReturn(obj);

        ItemCardapio resultado = service.save(obj);

        assertEquals(obj, resultado);
        verify(repository).save(obj);
    }

    @Test
    void deveBuscarTodosOsItemCardapios() {
        when(repository.findAll()).thenReturn(Arrays.asList(new ItemCardapio(), new ItemCardapio()));

        List<ItemCardapio> resultado = service.findAll();

        assertEquals(2, resultado.size());
        verify(repository).findAll();
    }

    @Test
    void deveBuscarItemCardapioPorId() {
        ItemCardapio obj = new ItemCardapio();
        obj.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(obj));

        ItemCardapio resultado = service.findById(1L);

        assertEquals(1L, resultado.getId());
        verify(repository).findById(1L);
    }

    @Test
    void deveDeletarItemCardapioPorId() {
        Long id = 1L;
        service.deleteById(id);
        verify(repository).deleteById(id);
    }
}