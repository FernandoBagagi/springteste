package br.com.ferdbgg.springteste.configuracoes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ferdbgg.springteste.entities.Pedido;
import br.com.ferdbgg.springteste.entities.Usuario;
import br.com.ferdbgg.springteste.entities.enums.StatusPedido;
import br.com.ferdbgg.springteste.repositories.PedidoRepository;
import br.com.ferdbgg.springteste.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class ConfiguracoesDeTestes implements CommandLineRunner{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Usuario> usuariosDumb = new ArrayList<>();
        usuariosDumb.add(new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null));
        usuariosDumb.add(new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123457", null));
        usuariosDumb.add(new Usuario(null, "Carlos José", "carlos@gmail.com", null, "123458", null));

        List<Pedido> pedidosDumb = new ArrayList<>();
        pedidosDumb.add(new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), usuariosDumb.get(0), StatusPedido.AGUARDANDO_PAGAMENTO.getCodigo()));
        pedidosDumb.add(new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), usuariosDumb.get(1), StatusPedido.CANCELADO.getCodigo()));
        pedidosDumb.add(new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), usuariosDumb.get(0), StatusPedido.ENTREGUE.getCodigo()));

        this.usuarioRepository.saveAll(usuariosDumb);
        this.pedidoRepository.saveAll(pedidosDumb);
    }
    
}
