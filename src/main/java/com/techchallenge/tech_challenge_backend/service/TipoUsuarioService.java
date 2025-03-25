
package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.model.TipoUsuario;
import com.techchallenge.tech_challenge_backend.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository repository;

    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return repository.save(tipoUsuario);
    }

    public List<TipoUsuario> findAll() {
        return repository.findAll();
    }

    public TipoUsuario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
