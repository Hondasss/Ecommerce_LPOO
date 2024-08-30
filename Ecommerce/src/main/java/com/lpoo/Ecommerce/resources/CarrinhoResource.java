package com.lpoo.Ecommerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lpoo.Ecommerce.entities.Carrinho;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.services.CarrinhoService;
import com.lpoo.Ecommerce.services.ProdutoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String verCarrinho(Model model) {
        Carrinho carrinho = carrinhoService.getCarrinhoAtual();
        double total = carrinho.getItens().stream()
            .mapToDouble(item -> item.getQuantidade() * item.getProduto().getPreco())
            .sum();
        model.addAttribute("carrinho", carrinho);
        model.addAttribute("total", total); // Adiciona o total ao modelo
        return "carrinhos";
    }

    @PostMapping("/adicionar")
    public String adicionarAoCarrinho(@RequestParam Long produtoId, @RequestParam Integer quantidade, RedirectAttributes redirectAttributes) {
        Produto produto = produtoService.findById(produtoId);
        if (produto != null) {
            carrinhoService.adicionarItem(produto, quantidade);
            redirectAttributes.addFlashAttribute("mensagem", "Produto adicionado ao carrinho com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Produto não encontrado.");
        }
        return "redirect:/produtos";
    }

    @PostMapping("/remover")
    public String removerDoCarrinho(@RequestParam Long itemId, RedirectAttributes redirectAttributes) {
        carrinhoService.removerItem(itemId);
        redirectAttributes.addFlashAttribute("mensagem", "Item removido do carrinho com sucesso!");
        return "redirect:/produtos";
    }

    @PostMapping("/finalizar")
    public String finalizarCompra(RedirectAttributes redirectAttributes) {
        carrinhoService.limparCarrinho();
        redirectAttributes.addFlashAttribute("mensagem", "Compra finalizada com sucesso!");
        return "redirect:/produtos";
    }
}