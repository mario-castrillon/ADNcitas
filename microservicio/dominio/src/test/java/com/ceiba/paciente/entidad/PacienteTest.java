package com.ceiba.paciente.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.BasePrueba;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;

class PacienteTest {
	
	@Test
	@DisplayName("Deberia Crear correctamente el Paciente")
	void deberiaCrearCorrectamenteElUsuario() {
		//Arrange
		Paciente paciente = new PacienteTestDataBuilder().conId(3L).build();
		//Assert-Act
		assertEquals(3, paciente.getIdPaciente());
		assertEquals("Nombre Paciente", paciente.getNombrePaciente());
		assertEquals("123456789", paciente.getCedula());
	}
	
	@Test
	@DisplayName("Deberia Fallar Sin Nombre de Paciente")
	void deberiaFallarSinNombrePaciente() {
		// Arrange
		PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder().conNombre(null).conId(1L);
		// Act-Assert
		BasePrueba.assertThrows(() -> {
			pacienteTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del paciente");
	}
	
	@Test
	@DisplayName("Deberia Fallar Sin Cedula")
	void deberiaFallarSinCedula() {
		// Arrange
		PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder().conCedula(null).conId(1L);
		// Act-Assert
		BasePrueba.assertThrows(() -> {
			pacienteTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la cedula del paciente");
	}

}
