package com.lpoo.Ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpoo.Ecommerce.entities.Carrinho;
import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.CarrinhoRepository;
import com.lpoo.Ecommerce.repositories.ItemCarrinhoRepository;
import com.lpoo.Ecommerce.repositories.ProdutoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    private Carrinho carrinhoAtual;

    public CarrinhoService() {
        this.carrinhoAtual = new Carrinho(); // Inicializa o carrinho atual
    }

    public void adicionarProduto(Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(produto);
        item.setCarrinho(carrinhoAtual);
        item.setQuantidade(1);
        itemCarrinhoRepository.save(item);
    }

    public void removerItem(Long itemId) {
        itemCarrinhoRepository.deleteById(itemId);
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return itemCarrinhoRepository.findByCarrinho(carrinhoAtual);
    }
}

