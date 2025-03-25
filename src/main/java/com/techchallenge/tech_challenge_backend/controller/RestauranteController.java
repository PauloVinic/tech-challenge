
package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.model.Restaurante;
import com.techchallenge.tech_challenge_backend.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {
    @Autowired
    private RestauranteService service;

    @PostMapping
    public Restaurante create(@RequestBody Restaurante restaurante) {
        return service.save(restaurante);
    }

    @GetMapping
    public List<Restaurante> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Restaurante getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
