
package com.techchallenge.tech_challenge_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String tipoCozinha;
    private String horarioFuncionamento;

    @ManyToOne
    private User dono;
}
