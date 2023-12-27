package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entities.Usuario;
import br.com.ferdbgg.springteste.repositories.UsuarioRepository;

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

    public Usuario insert(Usuario novoUsuario) {
        return this.usuarioRepository.save(novoUsuario);
    }

    public void deleteById(Integer id) {
        this.usuarioRepository.deleteById(id);
    }

    public Usuario update(Integer id, Usuario usuarioNovosDados) {
        Usuario usuarioMonitoradoJPA = this.usuarioRepository.getReferenceById(id);
        this.atualizarDados(usuarioMonitoradoJPA, usuarioNovosDados);
        return this.usuarioRepository.save(usuarioMonitoradoJPA);
    }

    private void atualizarDados(Usuario usuarioMonitoradoJPA, Usuario usuarioNovosDados) {
       usuarioMonitoradoJPA.setNome(usuarioNovosDados.getNome()); 
       usuarioMonitoradoJPA.setEmail(usuarioNovosDados.getEmail());
       usuarioMonitoradoJPA.setTelefone(usuarioNovosDados.getTelefone());
    }

}
