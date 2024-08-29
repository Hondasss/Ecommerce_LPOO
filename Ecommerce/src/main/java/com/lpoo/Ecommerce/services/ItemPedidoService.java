package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.ItemPedido;
import com.lpoo.Ecommerce.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository repository;
	
	public List<ItemPedido> findAll() {
		return repository.findAll();
	}
	
	public ItemPedido findById(Long id) {
		Optional<ItemPedido> obj = repository.findById(id);	
		return obj.get();
	}
 }
