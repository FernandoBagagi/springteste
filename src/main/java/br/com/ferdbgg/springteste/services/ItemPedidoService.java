package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entities.ItemPedido;
import br.com.ferdbgg.springteste.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> findAll() {
        return this.itemPedidoRepository.findAll();
    }

    public ItemPedido findById(Integer id) {
        Optional<ItemPedido> itemPedido = this.itemPedidoRepository.findById(id);
        return itemPedido.isPresent() ? itemPedido.get() : new ItemPedido();
    }

}
