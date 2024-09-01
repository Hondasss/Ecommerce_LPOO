package com.lpoo.Ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.lpoo.Ecommerce.enums.StatusPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedidos")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
																				
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	private double valorTotal;
	
	private StatusPedido status;
	
	public Pedido() {
	}

	public Pedido(Long id, Cliente cliente, StatusPedido status) {
		this.cliente = cliente;
		this.status = status;
		this.id = id;
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

	// Método para calcular o valor total do pedido
	public Double getValorTotal() {
		return itens.stream().mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade()).sum();
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	// Método para adicionar um item ao pedido
	public void addItem(ItemPedido item) {
		itens.add(item);
		item.setPedido(this);
	}


}
