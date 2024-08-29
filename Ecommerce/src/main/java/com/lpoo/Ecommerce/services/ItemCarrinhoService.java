package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.repositories.ItemCarrinhoRepository;

@Service
public class ItemCarrinhoService {
	
	@Autowired
	private ItemCarrinhoRepository repository;
	
	public List<ItemCarrinho> findAll() {
		return repository.findAll();
	}
	
	public ItemCarrinho findById(Long id) {
		Optional<ItemCarrinho> obj = repository.findById(id);	
		return obj.get();
	}
 }
