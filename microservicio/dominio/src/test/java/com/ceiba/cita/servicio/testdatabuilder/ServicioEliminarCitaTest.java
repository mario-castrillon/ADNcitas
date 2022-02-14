package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioEliminarCita;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCitaTest {

    @Test
    @DisplayName("Deberia eliminar la cita llamando al repositorio")
    void deberiaEliminarCitaLlamandoAlRepositorio(){
        // Arrange
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        ServicioEliminarCita servicioEliminarCita = new ServicioEliminarCita(repositorioCita);
        // Act
        servicioEliminarCita.ejecutar(1L);
        // Assert
        Mockito.verify(repositorioCita, Mockito.times(1)).eliminar(1L);
    }
}
