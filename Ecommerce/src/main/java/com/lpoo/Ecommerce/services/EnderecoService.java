package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.repositories.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository repository;
    
    public Endereco save(Endereco endereco) {
        return repository.save(endereco);        
    }
    
    public List<Endereco> findAll() {
        return repository.findAll();
    }
    
    public Endereco findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}