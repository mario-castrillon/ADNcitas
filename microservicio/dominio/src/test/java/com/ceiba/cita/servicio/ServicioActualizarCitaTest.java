package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarCitaTest {

    @Test
    @DisplayName("Deberia actualizar correctamente la cita en el repositorio")
    void deberiaActualizarCorrectamenteLaCitaEnElRepositorio(){
        // Arrange
        Cita cita = new CitaTestDataBuilder().conId(3L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        // Act
        servicioActualizarCita.ejecutar(cita);
        // Assert
        Mockito.verify(repositorioCita, Mockito.times(1)).actualizar(cita);
    }

    @Test
    @DisplayName("Deberia fallar si la cita no existe")
    void deberiaFallarSiLaCitaNoExiste(){
        // Arrange
        Cita cita = new CitaTestDataBuilder().conId(3L).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCita servicioActualizarCita = new ServicioActualizarCita(repositorioCita);
        // Act - Assert
        BasePrueba.assertThrows(()-> servicioActualizarCita.ejecutar(cita), ExcepcionDuplicidad.class,
                "La cita no existe en el sistema");
    }
}
