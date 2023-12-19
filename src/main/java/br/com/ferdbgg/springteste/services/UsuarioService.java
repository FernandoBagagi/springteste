package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entidades.Usuario;
import br.com.ferdbgg.springteste.repositorios.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.isPresent() ? usuario.get() : new Usuario();
    }

}
