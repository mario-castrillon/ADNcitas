package com.ceiba.paciente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.servicio.testdatabuilder.ComandoPacienteTestDataBuilder;
import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.ComandoPacienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPaciente.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorPacienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un paciente")
    void deberiaCrearUnUsuario() throws Exception{
        // arrange
        ComandoPaciente paciente = new ComandoPacienteTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un paciente")
    void deberiaActualizarUnPaciente() throws Exception{
        // Arrange
        Long idPaciente = 1L;
        ComandoPaciente paciente = new ComandoPacienteTestDataBuilder().build();
        // Act - Assert
        mocMvc.perform(put("/pacientes/{idPaciente}",idPaciente)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(paciente)))
                        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un paciente")
    void deberiaEliminarUnPaciente() throws Exception {
        // arrange
        Long idPaciente = 1L;
        // act - assert
        mocMvc.perform(delete("/pacientes/{idPaciente}",idPaciente)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
