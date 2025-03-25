
package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.model.ItemCardapio;
import com.techchallenge.tech_challenge_backend.service.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/itens-cardapio")
public class ItemCardapioController {
    @Autowired
    private ItemCardapioService service;

    @PostMapping
    public ItemCardapio create(@RequestBody ItemCardapio item) {
        return service.save(item);
    }

    @GetMapping
    public List<ItemCardapio> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemCardapio getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
