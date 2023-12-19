package br.com.ferdbgg.springteste.configuracoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ferdbgg.springteste.entities.Usuario;
import br.com.ferdbgg.springteste.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class ConfiguracoesDeTestes implements CommandLineRunner{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Usuario> usuariosDumb = new ArrayList<>();
        usuariosDumb.add(new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"));
        usuariosDumb.add(new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123457"));
        usuariosDumb.add(new Usuario(null, "Carlos José", "carlos@gmail.com", null, "123458"));

        this.usuarioRepository.saveAll(usuariosDumb);
    }
    
}
