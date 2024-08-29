package com.lpoo.Ecommerce.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.services.ItemCarrinhoService;

@RestController
@RequestMapping(value = "/itemCarrinhos")
public class ItemCarrinhoResource {
	
	@Autowired
	private ItemCarrinhoService service;
	
	@GetMapping
	public ResponseEntity<List<ItemCarrinho>> findAll() {
		List<ItemCarrinho> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemCarrinho> findById(@PathVariable Long id) {
		ItemCarrinho cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);
		
	}
}
