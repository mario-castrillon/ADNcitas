package com.ceiba.cita.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

class CitaTest {
	
	@Test
	@DisplayName("Deberia crear correctamente la Cita")
	void deberiaCrearCorrectamenteLaCita() {
		//Arrange
		Cita cita = new CitaTestDataBuilder().conId(3L).build();
		// Act - Assert
		assertEquals(6L, cita.getIdPaciente());
		assertEquals(9L, cita.getIdEspecialista());
		assertEquals(LocalDateTime.of(2022, 3, 3, 15, 0, 0), cita.getFecha());
	}
	
	@Test
	@DisplayName("Deberia fallar sin id de paciente")
	void deberiaFallarSinIdDePaciente() {
		// Arrange
		CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conId(3L).conIdPaciente(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> {
			citaTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el paciente");
	}
	
	@Test
	@DisplayName("Deberia fallar sin id de especialista")
	void deberiaFallarSinIdDeEspecialista() {
		// Arrange
		CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conId(3L).conIdEspecialista(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> {
			citaTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el especialista");
	}
	
	@Test
	@DisplayName("Deberia fallar sin fecha")
	void deberiaFallarSinFecha() {
		// Arrange
		CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conId(3L).conFecha(null);
		// Act - Assert
		BasePrueba.assertThrows(() -> {
			citaTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha");
	}
	
	@Test
	@DisplayName("Deberia fallar con hora menor de las 8")
	void deberiaFallarConHoraMenorDeLasOcho() {
		// Arrange
		LocalDate fecha = LocalDate.now().plusDays(1);
		LocalTime hora = LocalTime.of(4, 0);
		CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conId(3L).conFecha(LocalDateTime.of(fecha, hora));
		// Act - Assert
		BasePrueba.assertThrows(() -> {
			citaTestDataBuilder.build();
		}, ExcepcionValorInvalido.class, "La hora debe ser mayor o igual a las 8");
	}
	
	@Test
	@DisplayName("Deberia fallar con hora mayor de las 17")
	void deberiaFallarConHoraMayorDeLasCinco() {
		// Arrange
		LocalDate fecha = LocalDate.now().plusDays(1);
		LocalTime hora = LocalTime.of(19, 0);
		CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conId(3L).conFecha(LocalDateTime.of(fecha, hora));
		// Act - Assert
		BasePrueba.assertThrows(() -> {
			citaTestDataBuilder.build();
		}, ExcepcionValorInvalido.class, "La hora debe ser menor o igual a las 17");
	}
	
	@Test
	@DisplayName("Deberia fallar con fecha de dia menor al siguiente")
	void deberiaFallarConDiaMenorAlSiguiente() {
		// Arrange
		LocalDateTime fecha = LocalDateTime.now().plusDays(-1);
		
		CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conId(3L).conFecha(fecha);
		// Act - Assert
		BasePrueba.assertThrows(() -> {
			citaTestDataBuilder.build();
		}, ExcepcionValorInvalido.class, "La fecha debe ser superior a la de hoy");
	}
}
