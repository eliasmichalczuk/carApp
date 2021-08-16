package com.elias.michalczuk.carApp.veiculo.api;

import com.elias.michalczuk.carApp.TestUtils;
import com.elias.michalczuk.carApp.veiculo.api.dto.CreateVeiculoDto;
import com.elias.michalczuk.carApp.veiculo.domain.Marca;
import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import com.elias.michalczuk.carApp.veiculo.repository.VeiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreateVeiculoControllerTest {

    public static final String VEICULOS = "/veiculos";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Before
    public void before() {
    }

    @Test
    public void shouldCreateVeiculo() throws Exception {

        var body = CreateVeiculoDto.builder().ano(1991l).marca(Marca.TOYOTA).vendido(false).build();
        mockMvc.perform(MockMvcRequestBuilders.post(VEICULOS, 1L)
                .content(TestUtils.objectToJson(body))
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        var veiculo = veiculoRepository.findById(1).get();
        Assertions.assertEquals(1991, veiculo.getAno());
        Assertions.assertEquals(Marca.TOYOTA, veiculo.getMarca());
        Assertions.assertEquals(false, veiculo.getVendido());
    }

}
