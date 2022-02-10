package com.ceiba.paciente.servicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.BasePrueba;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;

class ServicioActualizarPacienteTest {
	
	@Test
	@DisplayName("Deberia validar la existencia del paciente")
	void deberiaValidarLaExistenciaDelPaciente() {
		//Arrange
		Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
		RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
		Mockito.when(repositorioPaciente.existePorId(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
		//Act - Assert
		BasePrueba.assertThrows(() -> servicioActualizarPaciente.ejecutar(paciente), ExcepcionDuplicidad.class, "El paciente no existe en el sistema");
	}
	
	@Test
	@DisplayName("Deberia actualizar correctamente el paciente en el repositorio")
	void deberiaActualizarCorrectamenteElPacienteEnElRepositorio() {
		//arrange
		Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
		RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
		Mockito.when(repositorioPaciente.existePorId(Mockito.anyLong())).thenReturn(true);
		ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
		//Act
		servicioActualizarPaciente.ejecutar(paciente);
		//Assert
		Mockito.verify(repositorioPaciente, Mockito.times(1)).actualizar(paciente);
	}

}
