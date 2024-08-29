package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }
    
    public Endereco findById(Long id) {
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElse(null);
    }
    
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
    
    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }
}
