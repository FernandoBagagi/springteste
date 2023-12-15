package br.com.ferdbgg.springteste.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferdbgg.springteste.entidades.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(1, "Carlos", "carlos@gmail.com", null, "1234");
        return ResponseEntity.ok().body(u);
    }
    
}
