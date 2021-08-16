package com.elias.michalczuk.carApp.veiculo.api.dto;

import com.elias.michalczuk.carApp.veiculo.domain.Marca;
import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatchVeiculoDto {

    private Marca marca;
    private Long ano;
    private String descricao;
    private boolean vendido;

    public Veiculo toVeiculo() {
        return Veiculo.builder()
                .marca(marca).ano(ano).descricao(descricao).vendido(vendido).created(Instant.now()).updated(Instant.now()).build();
    }
}
