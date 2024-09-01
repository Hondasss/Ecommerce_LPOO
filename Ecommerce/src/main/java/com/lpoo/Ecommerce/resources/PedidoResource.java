package com.lpoo.Ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lpoo.Ecommerce.entities.Pedido;
import com.lpoo.Ecommerce.services.PedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoResource {

    @Autowired
    private PedidoService service;	

    @GetMapping
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = service.findAll();
        if (pedidos.isEmpty()) {
            // Log para debug
            System.out.println("Nenhum pedido encontrado");
        } else {
            System.out.println("Encontrados " + pedidos.size() + " pedidos");
        }
        model.addAttribute("pedidos", pedidos);
        return "pedido";
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Pedido pedido = service.findById(id);
        if (pedido == null) {
            // Você pode querer tratar o caso de pedido não encontrado aqui
            return "error"; // Nome da página de erro ou qualquer outra página de fallback
        }
        model.addAttribute("pedido", pedido);
        return "pedido"; // Nome da página HTML para detalhes do pedido
    }
}
