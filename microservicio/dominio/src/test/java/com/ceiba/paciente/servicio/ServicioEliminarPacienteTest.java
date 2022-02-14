package com.ceiba.paciente.servicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

class ServicioEliminarPacienteTest {
	
	@Test
	@DisplayName("Deberia eliminar el paciente llamando al respositorio")
	void deberiaEliminarPacienteLlamandoAlRepositorio() {
		//Arrange
		RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
		ServicioEliminarPaciente servicioEliminarPaciente = new ServicioEliminarPaciente(repositorioPaciente);
		//Act
		servicioEliminarPaciente.ejecutar(1l);
		//Assert
		Mockito.verify(repositorioPaciente, Mockito.times(1)).eliminar(1l);
	}
}
