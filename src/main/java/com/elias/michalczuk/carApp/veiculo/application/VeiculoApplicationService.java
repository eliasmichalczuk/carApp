package com.elias.michalczuk.carApp.veiculo.application;

import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import com.elias.michalczuk.carApp.veiculo.domain.exception.VeiculoNotFoundException;
import com.elias.michalczuk.carApp.veiculo.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@AllArgsConstructor
@Transactional
public class VeiculoApplicationService {

    private final VeiculoRepository veiculoRepository;

    public void patch(Veiculo veiculo, Integer id) {
        var savedVeiculo = veiculoRepository.findById(id)
                .orElseThrow(VeiculoNotFoundException::new);

        if (veiculo.getMarca() != null) {
            savedVeiculo.setMarca(veiculo.getMarca());
        }
        if (veiculo.getAno() != null) {
            savedVeiculo.setAno(veiculo.getAno());
        }
        if (veiculo.getDescricao() != null) {
            savedVeiculo.setDescricao(veiculo.getDescricao());
        }
        if (veiculo.getVendido() != null) {
            savedVeiculo.setVendido(veiculo.getVendido());
        }
        savedVeiculo.setUpdated(Instant.now());
    }

    public void put(Veiculo veiculo, Integer id) {
        var savedVeiculo = veiculoRepository.findById(id)
                .orElseThrow(VeiculoNotFoundException::new);

        savedVeiculo.alterar(veiculo.getMarca(), veiculo.getAno(), veiculo.getDescricao(), veiculo.getVendido());
    }

    public void delete(Integer id) {
        var savedVeiculo = veiculoRepository.findById(id)
                .orElseThrow(VeiculoNotFoundException::new);
        veiculoRepository.delete(savedVeiculo);
    }
}
