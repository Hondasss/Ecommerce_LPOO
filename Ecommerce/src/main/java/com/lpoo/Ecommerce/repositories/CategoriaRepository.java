package com.lpoo.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpoo.Ecommerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	
}
