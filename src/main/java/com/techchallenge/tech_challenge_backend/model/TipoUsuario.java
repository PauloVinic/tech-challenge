
package com.techchallenge.tech_challenge_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTipo;
}
