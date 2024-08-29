package com.lpoo.Ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpoo.Ecommerce.entities.Carrinho;
import com.lpoo.Ecommerce.entities.ItemCarrinho;

public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, Long>{

	List<ItemCarrinho> findByCarrinho(Carrinho carrinhoAtual);
	
	
}
