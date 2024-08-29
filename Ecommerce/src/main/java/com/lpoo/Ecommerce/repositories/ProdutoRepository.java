package com.lpoo.Ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpoo.Ecommerce.entities.Categoria;
import com.lpoo.Ecommerce.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	List<Produto> findByCategoria(Categoria categoria);
}
