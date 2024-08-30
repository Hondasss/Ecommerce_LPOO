package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoService enderecoService;
    
    public List<Cliente> findAll() {
        return repository.findAll();
    }
    
    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);  
        return obj.orElse(null);
    }
    
    @Transactional
    public Cliente save(Cliente cliente) {
        if (cliente.getEndereco() != null) {
            Endereco savedEndereco = enderecoService.save(cliente.getEndereco());
            cliente.setEndereco(savedEndereco);
        }
        return repository.save(cliente);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    public void updateEndereco(Long id, Endereco endereco) {
        Cliente cliente = findById(id);
        if (cliente != null) {
            cliente.setEndereco(endereco);
            repository.save(cliente);
        }
    }
}
