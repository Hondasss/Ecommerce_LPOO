package com.lpoo.Ecommerce.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lpoo.Ecommerce.entities.Carrinho;
import com.lpoo.Ecommerce.entities.Categoria;
import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.entities.ItemPedido;
import com.lpoo.Ecommerce.entities.Pedido;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.enums.StatusPedido;
import com.lpoo.Ecommerce.repositories.CarrinhoRepository;
import com.lpoo.Ecommerce.repositories.CategoriaRepository;
import com.lpoo.Ecommerce.repositories.ClienteRepository;
import com.lpoo.Ecommerce.repositories.EnderecoRepository;
import com.lpoo.Ecommerce.repositories.ItemCarrinhoRepository;
import com.lpoo.Ecommerce.repositories.ItemPedidoRepository;
import com.lpoo.Ecommerce.repositories.PedidoRepository;
import com.lpoo.Ecommerce.repositories.ProdutoRepository;

@Configuration
public class RootConfig implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ItemCarrinhoRepository itemCarrinhoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		/*
		Categoria cat1 = new Categoria(null, "Mkt");
		categoriaRepository.saveAll(Arrays.asList(cat1));
		Produto prod = new Produto(null, "Oculos", "Inox", 30.20, cat1);
		produtoRepository.saveAll(Arrays.asList(prod));
		
		//Cliente c1 = new Cliente("Guilherme", "000222200022", "email@gmail.com", new Endereco(null, "log", "num", "bairro", "cid", "est", "cep"));
		//Cliente c2 = new Cliente("Robson", "11111200022", "email2@gmail.com", new Endereco(null, "losg", "nums", "bairros", "cids", "ests", "ceps"));
		/*
		
		Carrinho car1 = new Carrinho();
		Endereco e1 = new Endereco(null, "Mossoro", "81", "Centro", "Londrina", "PR", "8888888");
		
		ItemCarrinho ic = new ItemCarrinho(null, prod,car1, 4);
		ItemPedido ip = new ItemPedido(null, prod, 1);
		Pedido p = new Pedido(null, c1, Arrays.asList(ip), 40.10, StatusPedido.ENVIADO);
		Carrinho car = new Carrinho(null, Arrays.asList(ic));
		
		clienteRepository.saveAll(Arrays.asList(c1));
		
		
		carrinhoRepository.saveAll(Arrays.asList(car));
		enderecoRepository.saveAll(Arrays.asList(e1));
		itemCarrinhoRepository.saveAll(Arrays.asList(ic));
		itemPedidoRepository.saveAll(Arrays.asList(ip));
		pedidoRepository.saveAll(Arrays.asList(p));
		
		
		*/
	}
}
