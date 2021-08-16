package com.elias.michalczuk.carApp.veiculo.api.dto;

import com.elias.michalczuk.carApp.veiculo.domain.Marca;
import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateVeiculoDto {

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
