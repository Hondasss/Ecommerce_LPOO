package com.lpoo.Ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.ProdutoRepository;
import com.lpoo.Ecommerce.repositories.CategoriaRepository;

@Controller
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository; // Supondo que você tenha um CategoriaRepository para acessar as categorias

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/produtos/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categoriaRepository.findAll()); // Adiciona a lista de categorias ao modelo
        return "produtosCadastra";
    }

    @PostMapping("/produtos/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, Model model) {
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }
}

