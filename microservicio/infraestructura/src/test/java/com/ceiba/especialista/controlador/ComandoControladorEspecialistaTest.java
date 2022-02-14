package com.ceiba.especialista.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.controlador.ComandoControladorEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servicio.testdatabuilder.ComandoEspecialistaTestDataBuilder;
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
@WebMvcTest(ComandoControladorEspecialista.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorEspecialistaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia actualizar un especialista")
    void deberiaActualizarUnEspecialista() throws Exception{
        // Arrange
        Long idEspecialista = 1L;
        ComandoEspecialista especialista = new ComandoEspecialistaTestDataBuilder().build();
        // Act - Assert
        mocMvc.perform(put("/especialistas/{idEspecialista}", idEspecialista)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(especialista)))
                        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un especialista")
    void deberiaEliminarUnEspecialista() throws Exception{
        // Arrange
        Long idEspecialista = 1L;
        // Act - Assert
        mocMvc.perform(delete("/especialistas/{idEspecialista}", idEspecialista)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/especialistas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
