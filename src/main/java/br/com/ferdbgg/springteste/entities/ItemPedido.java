package br.com.ferdbgg.springteste.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ferdbgg.springteste.entities.primarykeys.IdItemPedido;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="item_pedido")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    @EqualsAndHashCode.Include
    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) private IdItemPedido id;

    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        this.id = new IdItemPedido(pedido, produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    @JsonIgnore
    public Pedido getPedido() {
        return this.id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        this.id.setPedido(pedido);
    }

    public Produto getProduto() {
        return this.id.getProduto();
    }

    public void setProduto(Produto produto) {
        this.id.setProduto(produto);
    }
}
