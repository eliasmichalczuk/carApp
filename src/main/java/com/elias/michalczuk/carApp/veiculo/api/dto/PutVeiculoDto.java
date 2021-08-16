package com.elias.michalczuk.carApp.veiculo.api.dto;

import com.elias.michalczuk.carApp.veiculo.domain.Marca;
import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PutVeiculoDto {

    @NonNull
    private Marca marca;
    @NonNull
    private Long ano;
    private String descricao;
    @NonNull
    private boolean vendido;

    public Veiculo toVeiculo() {
        return Veiculo.builder()
                .marca(marca).ano(ano).descricao(descricao).vendido(vendido).created(Instant.now()).updated(Instant.now()).build();
    }
}
