
package com.techchallenge.tech_challenge_backend.service;

import com.techchallenge.tech_challenge_backend.model.ItemCardapio;
import com.techchallenge.tech_challenge_backend.repository.ItemCardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemCardapioService {
    @Autowired
    private ItemCardapioRepository repository;

    public ItemCardapio save(ItemCardapio item) {
        return repository.save(item);
    }

    public List<ItemCardapio> findAll() {
        return repository.findAll();
    }

    public ItemCardapio findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
