package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Categoria;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);	
		return obj.get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}

 }
