package br.com.ferdbgg.springteste.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;
    private String descricao;
    private Double preco;
    private String urlImagem;

    @ManyToMany
    @JoinTable(name = "produtos_categorias", joinColumns = @JoinColumn(name = "id_produto"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "id.produto")
    @JsonIgnore
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private Set<ItemPedido> itens = new HashSet<>();

    public Produto(Integer id, String nome, String descricao, Double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.urlImagem = urlImagem;
    }

    @JsonIgnore
    public Set<Pedido> getPedidos() {
        return this.itens != null
                ? this.itens.stream().map(ItemPedido::getPedido).collect(Collectors.toSet())
                : new HashSet<>();
    }

}
