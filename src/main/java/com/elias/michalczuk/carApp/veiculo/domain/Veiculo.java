package com.elias.michalczuk.carApp.veiculo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.Clock;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Marca marca;
    private Long ano;
    private String descricao;
    private Boolean vendido;
    private Instant created;
    private Instant updated;

    public void alterar(Marca marca, Long ano, String descricao, Boolean vendido) {
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
        this.vendido = vendido;
        this.updated = Instant.now();
    }
}
