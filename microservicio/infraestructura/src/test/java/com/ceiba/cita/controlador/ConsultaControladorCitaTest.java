package com.ceiba.cita.controlador;

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
@WebMvcTest(ConsultaControladorCita.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorCitaTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deberia listar citas")
    void deberiaListarCitas() throws Exception{
        // Arrange
        // Act - Assert
        mockMvc.perform(get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].fecha", is("2022-02-18 11:00:00")))
                .andExpect(jsonPath("$[0].nombrePaciente", is("pacienteTest")))
                .andExpect(jsonPath("$[0].cedula", is("123456")))
                .andExpect(jsonPath("$[0].nombreEspecialista", is("Juan Especi")))
                .andExpect(jsonPath("$[0].especialidad", is("Especialidad ing")))
                .andExpect(jsonPath("$[0].tarifa", is(30000)));
    }
}