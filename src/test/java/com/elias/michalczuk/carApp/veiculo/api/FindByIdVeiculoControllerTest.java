package com.elias.michalczuk.carApp.veiculo.api;

import com.elias.michalczuk.carApp.veiculo.domain.Marca;
import com.elias.michalczuk.carApp.veiculo.domain.Veiculo;
import com.elias.michalczuk.carApp.veiculo.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class FindByIdVeiculoControllerTest {

    public static final String VEICULOS = "/veiculos/1";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Before
    public void before() {
        veiculoRepository.save(Veiculo.builder().ano(1990l).marca(Marca.TOYOTA).build());
    }

    @Test
    public void shouldFindVeiculoById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(VEICULOS, 1L)
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
        .andExpect(MockMvcResultMatchers.jsonPath("$.ano").value(1990))
        .andExpect(MockMvcResultMatchers.jsonPath("$.marca").value(Marca.TOYOTA.name()));
    }

}
