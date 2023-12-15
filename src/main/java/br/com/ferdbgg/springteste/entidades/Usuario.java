package br.com.ferdbgg.springteste.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

}
