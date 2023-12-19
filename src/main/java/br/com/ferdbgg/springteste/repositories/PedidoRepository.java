package br.com.ferdbgg.springteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ferdbgg.springteste.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
   
}
