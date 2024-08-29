package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Categoria;
import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);	
		return obj.get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	Produto save(Produto produto) {
		return repository.save(produto);
	}

	public List<Produto> findByCategoria(Categoria categoria) {
		return repository.findByCategoria(categoria);
	}
 }
