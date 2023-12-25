package br.com.ferdbgg.springteste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferdbgg.springteste.entities.ItemPedido;
import br.com.ferdbgg.springteste.services.ItemPedidoService;

@RestController
@RequestMapping(value = "/itenspedido")
public class ItemPedidoResource {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll(){
        List<ItemPedido> itensPedido = this.itemPedidoService.findAll();
        return ResponseEntity.ok().body(itensPedido);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Integer id){
        ItemPedido itemPedido = this.itemPedidoService.findById(id);
        return ResponseEntity.ok().body(itemPedido);
    }

}
