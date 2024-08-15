package com.lpoo.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carrinho")
public class Carrinho implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private List<ItemCarrinho> itens = new ArrayList<>();
	
	public Carrinho() {
	}

	public Carrinho(Long id, List<ItemCarrinho> itens) {
		this.id = id;
		this.itens = itens;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

}
