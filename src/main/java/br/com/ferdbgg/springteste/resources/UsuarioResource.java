package br.com.ferdbgg.springteste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferdbgg.springteste.entities.Usuario;
import br.com.ferdbgg.springteste.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = this.usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario usuario = this.usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

}
