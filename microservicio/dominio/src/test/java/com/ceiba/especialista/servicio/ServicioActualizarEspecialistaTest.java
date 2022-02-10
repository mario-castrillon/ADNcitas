package com.ceiba.especialista.servicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaTestDataBuilder;

class ServicioActualizarEspecialistaTest {

	@Test
	@DisplayName("Deberia validar la existencia del especialista")
	void deberiaValidarLaExistenciaDelEspecialista() {
		// Arrange
		Especialista especialista = new EspecialistaTestDataBuilder().conId(1L).build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(false);
		ServicioActualizarEspecialista servicioActualizarEspecialista = new ServicioActualizarEspecialista(
				repositorioEspecialista);
		// Act - Assert
		BasePrueba.assertThrows(() -> servicioActualizarEspecialista.ejecutar(especialista), ExcepcionDuplicidad.class,
				"El especialista no existe en el sistema");
	}

	@Test
	@DisplayName("Deberia actualizar correctamente el especialista en el repositorio")
	void deberiaActualizarCorrectamenteElEspecialistaEnElRepositorio() {
		// Arrange
		Especialista especialista = new EspecialistaTestDataBuilder().conId(1L).build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(true);
		ServicioActualizarEspecialista servicioActualizarEspecialista = new ServicioActualizarEspecialista(
				repositorioEspecialista);
		// Act
		servicioActualizarEspecialista.ejecutar(especialista);
		// Assert
		Mockito.verify(repositorioEspecialista, Mockito.times(1)).actualizar(especialista);
	}
}
