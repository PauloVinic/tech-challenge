
package com.techchallenge.tech_challenge_backend.controller;

import com.techchallenge.tech_challenge_backend.model.TipoUsuario;
import com.techchallenge.tech_challenge_backend.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tipos-usuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService service;

    @PostMapping
    public TipoUsuario create(@RequestBody TipoUsuario tipoUsuario) {
        return service.save(tipoUsuario);
    }

    @GetMapping
    public List<TipoUsuario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TipoUsuario getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
