package com.ceiba.especialista.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaTestDataBuilder;
import org.mockito.Mockito;

public class EspecialistaTest {

	@Test
	@DisplayName("Deberia Crear correctamente el Especialista")
	void deberiaCrearCorrectamenteElUsuario() {
		//Arrange
		Especialista especialista = new EspecialistaTestDataBuilder().conId(3L).build();
		//Assert-Act
		assertEquals(3, especialista.getIdEspecialista());
		assertEquals("Nombre Especialista", especialista.getNombreEspecialista());
		assertEquals("Especialidad", especialista.getEspecialidad());
		assertEquals(123000, especialista.getTarifa());
		assertEquals(6, especialista.getMaximoDiasAgendables());
	}
	
	@Test
	@DisplayName("Deberia Fallar Sin Nombre de Especialista")
	void deberiaFallarSinNombreEspecialista() {
		// Arrange
		EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder().conNombre(null).conId(1L);
		// Act-Assert
		BasePrueba.assertThrows(() -> {
			especialistaTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del especialista");
	}
	
	@Test
	@DisplayName("Deberia Fallar Sin Especialidad")
	void deberiaFallarSinEspecialiad() {
		// Arrange
		EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder().conEspecialidad(null).conId(1L);
		// Act-Assert
		BasePrueba.assertThrows(() -> {
			especialistaTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la especialidad");
	}

	// TODO Solucionar

	/*
	@Test
	@DisplayName("Deberia Fallar Sin Tarifa")
	void deberiaFallarSinTarifa() {

		EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder().conId(1L).conTarifa(Mockito.isNull());
		// Act-Assert
		BasePrueba.assertThrows(() -> {
			especialistaTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la tarifa");
	}

	 */
}


