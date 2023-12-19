package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entities.Pedido;
import br.com.ferdbgg.springteste.repositories.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository PedidoRepository;

    public List<Pedido> findAll() {
        return this.PedidoRepository.findAll();
    }

    public Pedido findById(Integer id) {
        Optional<Pedido> pedido = this.PedidoRepository.findById(id);
        return pedido.isPresent() ? pedido.get() : new Pedido();
    }

}
