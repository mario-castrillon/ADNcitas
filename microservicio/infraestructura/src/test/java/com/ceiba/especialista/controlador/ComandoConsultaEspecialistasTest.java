package com.ceiba.especialista.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.paciente.controlador.ConsultaControladorPaciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorPaciente.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class ComandoConsultaEspecialistasTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia listar especialistas")
    void deberiaListarEspecialistas() throws Exception{
        mockMvc.perform(get("/especialistas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].nombreEspecialista", is("Juan Especi")))
                .andExpect(jsonPath("$[0].idEspecialista", is(1)))
                .andExpect(jsonPath("$[0].especialidad", is("Especialidad ing")))
                .andExpect(jsonPath("$[0].tarifa", is(30000)))
                .andExpect(jsonPath("$[0].maximoDiasAgendables", is(6)));
    }
}

