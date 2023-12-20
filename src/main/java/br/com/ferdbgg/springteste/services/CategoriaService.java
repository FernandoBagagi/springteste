package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entities.Categoria;
import br.com.ferdbgg.springteste.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        return categoria.isPresent() ? categoria.get() : new Categoria();
    }

}
