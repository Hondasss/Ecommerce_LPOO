package com.lpoo.Ecommerce.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lpoo.Ecommerce.entities.Carrinho;
import com.lpoo.Ecommerce.entities.Cliente;
import com.lpoo.Ecommerce.entities.ItemCarrinho;
import com.lpoo.Ecommerce.entities.ItemPedido;
import com.lpoo.Ecommerce.entities.Pedido;
import com.lpoo.Ecommerce.entities.Produto;
import com.lpoo.Ecommerce.enums.StatusPedido;
import com.lpoo.Ecommerce.services.CarrinhoService;
import com.lpoo.Ecommerce.services.ClienteService;
import com.lpoo.Ecommerce.services.PedidoService;
import com.lpoo.Ecommerce.services.ProdutoService;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

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
        // 1. Obter o carrinho atual
        Carrinho carrinho = carrinhoService.getCarrinhoAtual();
        List<ItemCarrinho> itensDoCarrinho = carrinho.getItens();

        // 2. Criar a instância de Pedido
        Cliente cliente = clienteService.findById(1L);  // Cliente fixo com ID 1 para testes
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        // 3. Converter itens do carrinho para itens do pedido
        List<ItemPedido> itensPedido = itensDoCarrinho.stream().map(itemCarrinho -> {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(itemCarrinho.getProduto());
            itemPedido.setQuantidade(itemCarrinho.getQuantidade());
            itemPedido.setPedido(pedido);  // Associa o item ao pedido
            return itemPedido;
        }).collect(Collectors.toList());

        // 4. Associar os itens ao pedido e calcular o valor total
        pedido.setItens(itensPedido);
        double valorTotal = itensPedido.stream()
                .mapToDouble(item -> item.getProduto().getPreco() * item.getQuantidade())
                .sum();
        pedido.setValorTotal(valorTotal);
        pedido.setStatus(StatusPedido.PAGO); // Defina o status do pedido, ex: PENDENTE

        // 5. Salvar o pedido no banco de dados
        pedidoService.save(pedido);

        // 6. Limpar o carrinho
        carrinhoService.limparCarrinho();

        // 7. Adicionar mensagem de sucesso
        redirectAttributes.addFlashAttribute("mensagem", "Compra finalizada com sucesso!");

        return "redirect:/produtos";
    }
}
