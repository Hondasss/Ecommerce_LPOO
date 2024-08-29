package com.lpoo.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> findAll() {
		return repository.findAll();
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj = repository.findById(id);	
		return obj.get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
 }
