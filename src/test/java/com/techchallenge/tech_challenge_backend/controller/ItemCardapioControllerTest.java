package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.model.ItemCardapio;
import com.techchallenge.tech_challenge_backend.service.ItemCardapioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ItemCardapioControllerTest {

    @Mock
    private ItemCardapioService service;

    @InjectMocks
    private ItemCardapioController controller;
    
    @Test
    void deveCriarItemCardapio() {
        ItemCardapio obj = new ItemCardapio();
        when(service.save(obj)).thenReturn(obj);

        ItemCardapio resultado = controller.create(obj);

        assertNotNull(resultado);
        verify(service).save(obj);
    }
    @Test
    void deveListarTodosOsItemCardapios() {
        when(service.findAll()).thenReturn(List.of(new ItemCardapio(), new ItemCardapio()));

        List<ItemCardapio> resultado = controller.getAll();

        assertEquals(2, resultado.size());
        verify(service).findAll();
    }
    @Test
    void deveBuscarItemCardapioPorId() {
        ItemCardapio obj = new ItemCardapio();
        obj.setId(1L);
        when(service.findById(1L)).thenReturn(obj);

        ItemCardapio resultado = controller.getById(1L);

        assertEquals(1L, resultado.getId());
        verify(service).findById(1L);
    }
    @Test
    void deveDeletarItemCardapioPorId() {
        controller.delete(1L);
        verify(service).deleteById(1L);
    }
}