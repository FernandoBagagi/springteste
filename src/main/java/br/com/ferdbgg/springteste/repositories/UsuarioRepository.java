package br.com.ferdbgg.springteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferdbgg.springteste.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
   
}
