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

import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.Endereco;
import com.lpoo.Ecommerce.services.ClienteService;
import com.lpoo.Ecommerce.services.EnderecoService;

@Controller
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";	
    }

    @GetMapping("/clientes/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("endereco", new Endereco()); // Adiciona um novo objeto Endereco ao modelo
        return "clientesCadastra";
    }

    @PostMapping("/clientes/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente, @ModelAttribute Endereco endereco, RedirectAttributes redirectAttributes) {
        cliente.setEndereco(endereco);
        Cliente clienteSalvo = clienteService.save(cliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "redirect:/clientes";
    }
    
    @PostMapping("/clientes/deletar")
    public String deletarCliente(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            clienteService.deleteById(id);
            redirectAttributes.addFlashAttribute("mensagem", "Cliente deletado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao deletar o cliente: " + e.getMessage());
        }
        return "redirect:/clientes";
    }
}
