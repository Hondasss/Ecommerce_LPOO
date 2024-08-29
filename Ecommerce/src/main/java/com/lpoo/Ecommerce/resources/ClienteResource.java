package com.lpoo.Ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.services.ClienteService;

@Controller // Alterado para Controller para suportar renderização de views
@RequestMapping(value = "/clientes") // Ajustado o path para combinar com o exemplo anterior
public class ClienteResource {
    
    @Autowired
    private ClienteService service;
    
    // Método para retornar dados em JSON (API REST)
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Método para buscar cliente por ID (API REST)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente cliente = service.findById(id);
        return ResponseEntity.ok().body(cliente);
    }
    
 
}
