package br.com.ferdbgg.springteste.configuracoes;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ferdbgg.springteste.entities.Categoria;
import br.com.ferdbgg.springteste.entities.Pedido;
import br.com.ferdbgg.springteste.entities.Produto;
import br.com.ferdbgg.springteste.entities.Usuario;
import br.com.ferdbgg.springteste.entities.enums.StatusPedido;
import br.com.ferdbgg.springteste.repositories.CategoriaRepository;
import br.com.ferdbgg.springteste.repositories.PedidoRepository;
import br.com.ferdbgg.springteste.repositories.ProdutoRepository;
import br.com.ferdbgg.springteste.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class ConfiguracoesDeTestes implements CommandLineRunner{

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Categoria> categoriasDumb = new ArrayList<>();
        categoriasDumb.add(new Categoria(null, "Eletrônicos", new HashSet<>()));
        categoriasDumb.add(new Categoria(null, "Livros", new HashSet<>()));
        categoriasDumb.add(new Categoria(null, "Computadores", new HashSet<>()));
        this.categoriaRepository.saveAll(categoriasDumb);

        List<Produto> produtosDumb = new ArrayList<>();
        produtosDumb.add(new Produto(null, "Livro", "Descrição do livro", 27.89, null));
        produtosDumb.add(new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, null));
        produtosDumb.add(new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, null));
        produtosDumb.add(new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, null));
        produtosDumb.add(new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, null));
        produtosDumb.add(new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, null));
        this.produtoRepository.saveAll(produtosDumb);
        
        produtosDumb.get(0).getCategorias().add(categoriasDumb.get(1));
        produtosDumb.get(1).getCategorias().add(categoriasDumb.get(1));
        produtosDumb.get(2).getCategorias().add(categoriasDumb.get(0));
        produtosDumb.get(3).getCategorias().add(categoriasDumb.get(0));
        produtosDumb.get(3).getCategorias().add(categoriasDumb.get(2));
        produtosDumb.get(4).getCategorias().add(categoriasDumb.get(0));
        produtosDumb.get(4).getCategorias().add(categoriasDumb.get(2));
        produtosDumb.get(5).getCategorias().add(categoriasDumb.get(1));
        this.produtoRepository.saveAll(produtosDumb);
        
        List<Usuario> usuariosDumb = new ArrayList<>();
        usuariosDumb.add(new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null));
        usuariosDumb.add(new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123457", null));
        usuariosDumb.add(new Usuario(null, "Carlos José", "carlos@gmail.com", null, "123458", null));
        this.usuarioRepository.saveAll(usuariosDumb);

        List<Pedido> pedidosDumb = new ArrayList<>();
        pedidosDumb.add(new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), usuariosDumb.get(0), StatusPedido.AGUARDANDO_PAGAMENTO.getCodigo()));
        pedidosDumb.add(new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), usuariosDumb.get(1), StatusPedido.CANCELADO.getCodigo()));
        pedidosDumb.add(new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), usuariosDumb.get(0), StatusPedido.ENTREGUE.getCodigo()));
        this.pedidoRepository.saveAll(pedidosDumb);

    }
    
}
