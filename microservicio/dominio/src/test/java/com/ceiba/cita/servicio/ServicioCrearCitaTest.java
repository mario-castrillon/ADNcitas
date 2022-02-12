package com.ceiba.cita.servicio;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaDtoTestDataBuilder;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaDtoTestDataBuilder;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaTestDataBuilder;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearCitaTest {

    @Test
    @DisplayName("Debería Crear la Cita de manera correcta")
    void deberiaCrearLaCitaCorrectamente(){
        // Arrange
        Paciente paciente = new PacienteTestDataBuilder().build();
        Especialista especialista = new EspecialistaTestDataBuilder().build();
        Cita cita = new CitaTestDataBuilder().conId(3L).build();
        DtoCita dtoCita = new CitaDtoTestDataBuilder().build();
        DtoEspecialista dtoEspecialista = new EspecialistaDtoTestDataBuilder().conMaximoDiasAgendables(100).build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioPaciente.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioCita.existePorFecha(cita.getFecha())).thenReturn(false);
        Mockito.when(repositorioEspecialista.obtener(Mockito.anyLong())).thenReturn(dtoEspecialista);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita,repositorioPaciente,repositorioEspecialista);

        Long idCita = servicioCrearCita.ejecutar(cita);

        assertEquals(0, idCita);

        Mockito.verify(repositorioCita, Mockito.times(1)).crear(cita);
    }

    private void diasAgendablesSinFinesDeSemana(List<LocalDate> fechas, int dias) {
        int diasAgregados = 0;
        LocalDate temporal = LocalDate.now();

        while (diasAgregados < dias) {
            if (!(temporal.plusDays(1).getDayOfWeek() == DayOfWeek.SATURDAY
                    || temporal.plusDays(1).getDayOfWeek() == DayOfWeek.SUNDAY)) {
                fechas.add(temporal.plusDays(1));
                diasAgregados++;
            }
            temporal = temporal.plusDays(1);
        }
    }

}
