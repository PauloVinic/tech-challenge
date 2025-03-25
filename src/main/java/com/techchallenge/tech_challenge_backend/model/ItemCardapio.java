
package com.techchallenge.tech_challenge_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
public class ItemCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponivelApenasLocal;
    private String caminhoFoto;

    @ManyToOne
    private Restaurante restaurante;
}
