package com.elias.michalczuk.carApp.veiculo.api;

import com.elias.michalczuk.carApp.veiculo.api.dto.CreateVeiculoDto;
import com.elias.michalczuk.carApp.veiculo.api.dto.PatchVeiculoDto;
import com.elias.michalczuk.carApp.veiculo.application.VeiculoApplicationService;
import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import com.elias.michalczuk.carApp.veiculo.domain.exception.VeiculoNotFoundException;
import com.elias.michalczuk.carApp.veiculo.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Service
@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final VeiculoApplicationService veiculoApplicationService;

    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody CreateVeiculoDto veiculo) {
        return ResponseEntity.ok(veiculoRepository.save(veiculo.toVeiculo()));
    }

    @PatchMapping("/{id}")
    public ResponseEntity patch(@RequestBody PatchVeiculoDto veiculo, @PathVariable("id") String id) {
        veiculoApplicationService.patch(veiculo.toVeiculo(), Integer.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@RequestBody PatchVeiculoDto veiculo, @PathVariable("id") String id) {
        veiculoApplicationService.put(veiculo.toVeiculo(), Integer.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @GetMapping("/find")
    public List<Veiculo> findByQuery(@PathParam("marca") String marca, @PathParam("decada") Integer decada, @PathParam("vendido") Boolean vendido) {
        return veiculoRepository.findVeiculoByQuery(marca, decada, vendido);
    }

    @GetMapping("/{id}")
    public Veiculo findById(@PathVariable("id") Integer id) {
        return veiculoRepository.findById(id).orElseThrow(VeiculoNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        veiculoApplicationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
