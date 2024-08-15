package com.lpoo.Ecommerce.resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Endereco;

@RestController
@RequestMapping(value = "/clients")
public class ClienteResouce {
	
	//@GetMapping
	//public ResponseEntity<Cliente> findAll() {
		//Cliente client = new Cliente("Guilherme", "000222200222", "Paranaguá", new Endereco("log", "32","centro", "Londrina", "estado", "cep"));
		//return ResponseEntity.ok().body(client);
	//}
}
