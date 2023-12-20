package br.com.ferdbgg.springteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ferdbgg.springteste.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
   
}
