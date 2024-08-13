package com.lpoo.Ecommerce.entities;

import java.io.Serializable;

public class ItemCarrinho implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Produto produto;
	private Integer quantidade;
	
	public ItemCarrinho() {
	}

	public ItemCarrinho(Produto produto, Integer quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
