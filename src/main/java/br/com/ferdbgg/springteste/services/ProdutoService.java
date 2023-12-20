package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entities.Produto;
import br.com.ferdbgg.springteste.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return this.produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : new Produto();
    }

}
