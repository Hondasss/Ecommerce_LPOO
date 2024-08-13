package com.lpoo.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.lpoo.Ecommerce.enums.StatusPedido;

public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	private Double valorTotal;
	private StatusPedido status;
	
	public Pedido() {
	}

	public Pedido(Cliente cliente, List<ItemPedido> itens, Double valorTotal, StatusPedido status) {
		this.cliente = cliente;
		this.itens = itens;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, itens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(itens, other.itens);
	}
	
}
