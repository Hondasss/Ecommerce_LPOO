package com.lpoo.Ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpoo.Ecommerce.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	
}
