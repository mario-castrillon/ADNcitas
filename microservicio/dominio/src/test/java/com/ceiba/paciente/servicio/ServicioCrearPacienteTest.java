package com.ceiba.paciente.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;


class ServicioCrearPacienteTest {
	
	@Test
	@DisplayName("Deberia Crear el Paciente de manera correcta")
	void deberiaCrearElPacienteDeManeraCorrecta() {
		//Arrange
		Paciente paciente = new PacienteTestDataBuilder().build();
		RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
		Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(false);
		Mockito.when(repositorioPaciente.crear(paciente)).thenReturn(3L);
		ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
		//Act
		Long idPaciente = servicioCrearPaciente.ejecutar(paciente);
		//Assert
		assertEquals(3L, idPaciente);
		Mockito.verify(repositorioPaciente, Mockito.times(1)).crear(paciente);
	}

	@Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Paciente")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelUsuario() {
        //Arrange
        Paciente paciente = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
        //Act-Assert
        BasePrueba.assertThrows(() -> servicioCrearPaciente.ejecutar(paciente),
        						ExcepcionDuplicidad.class,"El paciente ya existe en el sistema");
    }
}
