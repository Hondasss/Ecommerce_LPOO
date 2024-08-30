package com.lpoo.Ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lpoo.Ecommerce.entities.Carrinho;
import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.CarrinhoRepository;
import com.lpoo.Ecommerce.repositories.ItemCarrinhoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    @Transactional
    public Carrinho getCarrinhoAtual() {
        return carrinhoRepository.findById(1L).orElseGet(() -> {
            Carrinho novoCarrinho = new Carrinho();
            return carrinhoRepository.save(novoCarrinho);
        });
    }

    @Transactional
    public void adicionarItem(Produto produto, Integer quantidade) {
        Carrinho carrinho = getCarrinhoAtual();
        
        // Verifica se o item já existe no carrinho
        ItemCarrinho itemExistente = carrinho.getItens().stream()
            .filter(item -> item.getProduto().getId().equals(produto.getId()))
            .findFirst()
            .orElse(null);

        if (itemExistente != null) {
            // Se o item já existe, atualiza a quantidade
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
            itemCarrinhoRepository.save(itemExistente);
        } else {
            // Se o item não existe, cria um novo
            ItemCarrinho novoItem = new ItemCarrinho(null, produto, carrinho, quantidade);
            itemCarrinhoRepository.save(novoItem);  // Salva o novo item primeiro
            carrinho.getItens().add(novoItem);  // Agora, adiciona ao carrinho
        }

        carrinhoRepository.save(carrinho);  // Salva o carrinho com a lista de itens atualizada
    }

    @Transactional
    public void removerItem(Long itemId) {
        ItemCarrinho item = itemCarrinhoRepository.findById(itemId).orElse(null);
        if (item != null) {
            Carrinho carrinho = item.getCarrinho();
            carrinho.getItens().remove(item);
            itemCarrinhoRepository.delete(item);  // Remova o item
            carrinhoRepository.save(carrinho);  // Salva o carrinho atualizado
        }
    }


    @Transactional
    public void limparCarrinho() {
        Carrinho carrinho = getCarrinhoAtual();
        itemCarrinhoRepository.deleteAll(carrinho.getItens());
        carrinho.getItens().clear();
        carrinhoRepository.save(carrinho);
    }
}