package com.lpoo.Ecommerce.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpoo.Ecommerce.entities.ItemPedido;
import com.lpoo.Ecommerce.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/itemPedidos")
public class ItemPedidoResource {
	
	@Autowired
	private ItemPedidoService service;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> findAll() {
		List<ItemPedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemPedido> findById(@PathVariable Long id) {
		ItemPedido cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);
		
	}
}
