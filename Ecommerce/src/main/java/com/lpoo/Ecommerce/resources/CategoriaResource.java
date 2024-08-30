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

import com.lpoo.Ecommerce.entities.Categoria;
import com.lpoo.Ecommerce.services.CategoriaService;

@Controller
public class CategoriaResource {
    
    @Autowired
    private CategoriaService service;
    
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = service.findAll();
        model.addAttribute("categorias", categorias); // Corrigido para "categorias"
        return "categoria";
    }
    
    @GetMapping("/categorias/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "cadastraCategoria";
    }

    @PostMapping("/categorias/salvar")
    public String salvarCategoria(@ModelAttribute Categoria categoria, Model model) {
        service.save(categoria);
        return "redirect:/categorias"; 
    }

    @PostMapping("/categorias/deletar")
    public String deletarCategoria(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        service.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Categoria deletada com sucesso!");
        return "redirect:/categorias";
    }
}
