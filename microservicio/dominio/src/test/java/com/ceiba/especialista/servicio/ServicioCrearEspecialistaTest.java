package com.ceiba.especialista.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaTestDataBuilder;

class ServicioCrearEspecialistaTest {

	@Test
	@DisplayName("Deberia Crear Especialista correctamente")
	void deberiaCrearElEspecialistaCorrectamente() {
		// Arrange
		Especialista especialista = new EspecialistaTestDataBuilder().build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioEspecialista.crear(especialista)).thenReturn(3L);
		ServicioCrearEspecialista servicioCrearEspecialista = new ServicioCrearEspecialista(repositorioEspecialista);

		// Assert-Act
		assertEquals(3L, servicioCrearEspecialista.ejecutar(especialista));
		Mockito.verify(repositorioEspecialista, Mockito.times(1)).crear(especialista);
	}
	
	@Test
	@DisplayName("Deberia lanzar Excepcion si el Especialista no existe")
	void deberiaLazarExcepcionSiElEspecialistaNoExiste() {
		// Arrange
		Especialista especialista = new EspecialistaTestDataBuilder().build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existe(Mockito.anyString())).thenReturn(true);
		ServicioCrearEspecialista servicioCrearEspecialista = new ServicioCrearEspecialista(repositorioEspecialista);
		// Act-Assert
		BasePrueba.assertThrows(() -> servicioCrearEspecialista.ejecutar(especialista),
										ExcepcionDuplicidad.class, "El especialista ya existe en el sistema");
	}
}
