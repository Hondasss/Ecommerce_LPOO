package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Pedido;
import com.lpoo.Ecommerce.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	// Retorna todos os pedidos
	public List<Pedido> findAll() {
		return repository.findAll();
	}
	
	// Retorna um pedido pelo ID
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Pedido não encontrado com ID: " + id));
	}

	// Salva um pedido no banco de dados
	public Pedido save(Pedido pedido) {
		return repository.save(pedido);
	}
}
