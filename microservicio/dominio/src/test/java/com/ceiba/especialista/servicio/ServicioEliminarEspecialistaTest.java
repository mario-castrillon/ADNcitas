package com.ceiba.especialista.servicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

class ServicioEliminarEspecialistaTest {
	
	@Test
	@DisplayName("Deberia eliminar el especialista llamando al respositorio")
	void deberiaEliminarEspecialistaLlamandoAlRepositorio() {
		//Arrange
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		ServicioEliminarEspecialista servicioEliminarEspecialista = new ServicioEliminarEspecialista(repositorioEspecialista);
		//Act
		servicioEliminarEspecialista.ejecutar(1l);
		//Assert
		Mockito.verify(repositorioEspecialista, Mockito.times(1)).eliminar(1l);
	}
}
