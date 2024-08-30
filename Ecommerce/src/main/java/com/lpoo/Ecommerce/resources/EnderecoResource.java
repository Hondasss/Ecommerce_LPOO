package com.lpoo.Ecommerce.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.services.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {
    
    @Autowired
    private EnderecoService service;
    
    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        Endereco savedEndereco = service.save(endereco);
        return ResponseEntity.ok(savedEndereco);
    }
    
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> enderecos = service.findAll();
        return ResponseEntity.ok(enderecos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id) {
        Endereco endereco = service.findById(id);
        return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
