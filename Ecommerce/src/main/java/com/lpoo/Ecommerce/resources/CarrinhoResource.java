package com.lpoo.Ecommerce.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.services.CarrinhoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/adicionar")
    public String adicionarProduto(@RequestParam("produtoId") Long produtoId) {
        carrinhoService.adicionarProduto(produtoId);
        return "redirect:/carrinhos";
    }

    @PostMapping("/remover")
    public String removerItem(@RequestParam("itemId") Long itemId) {
        carrinhoService.removerItem(itemId);
        return "redirect:/carrinhos";
    }

    @GetMapping
    public String verCarrinho(Model model) {
        List<ItemCarrinho> itensCarrinho = carrinhoService.getItensCarrinho();
        model.addAttribute("itensCarrinho", itensCarrinho);
        return "carrinhos";
    }
}

