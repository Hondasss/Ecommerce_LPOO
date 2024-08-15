package com.lpoo.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpoo.Ecommerce.entities.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
	
	
}
