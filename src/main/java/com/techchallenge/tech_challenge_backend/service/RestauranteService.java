
package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.model.Restaurante;
import com.techchallenge.tech_challenge_backend.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository repository;

    public Restaurante save(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    public List<Restaurante> findAll() {
        return repository.findAll();
    }

    public Restaurante findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
