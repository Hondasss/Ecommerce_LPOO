package com.lpoo.Ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.repositories.ProdutoRepository;
import com.lpoo.Ecommerce.services.ProdutoService;
import com.lpoo.Ecommerce.repositories.CategoriaRepository;

@Controller
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaRepository categoriaRepository; 

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/produtos/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categoriaRepository.findAll()); //Adiciona a lista de categorias as opções
        return "produtosCadastra";
    }

    @PostMapping("/produtos/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, Model model) {
        produtoService.save(produto);
        return "redirect:/produtos";
    }
    
    @PostMapping("/produtos/deletar")
    public String deletarProduto(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        produtoService.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Produto deletado com sucesso!");
        return "redirect:/produtos";
    }
}

