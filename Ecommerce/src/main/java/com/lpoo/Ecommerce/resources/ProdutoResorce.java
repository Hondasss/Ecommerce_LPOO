package com.lpoo.Ecommerce.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.ProdutoRepository;


@Controller
public class ProdutoResorce {
	
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }
}
