package br.com.ferdbgg.springteste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.ferdbgg.springteste.entities.Usuario;
import br.com.ferdbgg.springteste.repositories.UsuarioRepository;
import br.com.ferdbgg.springteste.services.exceptions.BancoDadosException;
import br.com.ferdbgg.springteste.services.exceptions.ObjetoNaoEncontradoException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjetoNaoEncontradoException(id));
    }

    public Usuario insert(Usuario novoUsuario) {
        return this.usuarioRepository.save(novoUsuario);
    }

    public void deleteById(Integer id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        if(usuario.isPresent()) {
            try {
                this.usuarioRepository.deleteById(id);
            } catch(DataIntegrityViolationException exception) {
                throw new BancoDadosException(exception.getMessage());
            }
        } else {
            throw new ObjetoNaoEncontradoException(id);
        }
    }

    public Usuario update(Integer id, Usuario usuarioNovosDados) {
        Usuario usuarioMonitoradoJPA = this.usuarioRepository.getReferenceById(id);
        //Dá EntityNotFoundException ao tentar acessar uma entidade que não está persistida
        try {
            this.atualizarDados(usuarioMonitoradoJPA, usuarioNovosDados);
            return this.usuarioRepository.save(usuarioMonitoradoJPA);
        } catch(EntityNotFoundException exception) {
            throw new ObjetoNaoEncontradoException(id);
        }
    }

    private void atualizarDados(Usuario usuarioMonitoradoJPA, Usuario usuarioNovosDados) {
        //Verificar se a regra de negócio permite colocar null ou não
        if(usuarioNovosDados.getNome() != null) {
            usuarioMonitoradoJPA.setNome(usuarioNovosDados.getNome()); 
        }
        if(usuarioNovosDados.getEmail() != null) {
            usuarioMonitoradoJPA.setEmail(usuarioNovosDados.getEmail());
        }
        if(usuarioNovosDados.getTelefone() != null) {
            usuarioMonitoradoJPA.setTelefone(usuarioNovosDados.getTelefone());
        }
    }

}
