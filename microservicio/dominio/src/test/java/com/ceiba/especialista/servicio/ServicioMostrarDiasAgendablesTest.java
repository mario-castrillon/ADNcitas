package com.ceiba.especialista.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaDtoTestDataBuilder;

class ServicioMostrarDiasAgendablesTest {
	
	@Test
	@DisplayName("Deberia lanzar una exepcion si el especialista no tiene dias agendables")
	void DeberiaLanzarExcepcionSiElEspecialistaNoTieneDiasAgendables() {
		// Arrange
		DtoEspecialista dtoEspecialista = new EspecialistaDtoTestDataBuilder().conMaximoDiasAgendables(0).conId(3L).build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioEspecialista.obtener(Mockito.anyLong())).thenReturn(dtoEspecialista);

		//Act
		ServicioMostrarDiasAgendables servicioMostrarDiasAgendables = new ServicioMostrarDiasAgendables(repositorioEspecialista);
		
		// Assert
		BasePrueba.assertThrows(() -> servicioMostrarDiasAgendables.ejecutar(3L),
				ExcepcionSinDatos.class, "El especialista no tiene dias agendables"
				);
	}
	
	@Test
	@DisplayName("Deberia lanzar una exepcion sin el especialista no existe")
	void DeberiaLanzarExcepcionSiElEspecialistaNoExiste() {
		// Arrange
		DtoEspecialista dtoEspecialista = new EspecialistaDtoTestDataBuilder().build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(false);

		//Act
		ServicioMostrarDiasAgendables servicioMostrarDiasAgendables = new ServicioMostrarDiasAgendables(repositorioEspecialista);
		
		// Assert
		BasePrueba.assertThrows(() -> servicioMostrarDiasAgendables.ejecutar(3L),
				ExcepcionSinDatos.class, "El especialista no existe"
				);
	}
	
	@Test
	@DisplayName("Deberia mostrar lista de dias disponibles sin fines de semana")
	void DeberiaMostrarListaDeDiasDispobiblesSinFinesDeSemana() {
		//Arrange
		DtoEspecialista dtoEspecialista = new EspecialistaDtoTestDataBuilder().conMaximoDiasAgendables(3).conId(3L).build();
		RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
		Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(true);
		Mockito.when(repositorioEspecialista.obtener(Mockito.anyLong())).thenReturn(dtoEspecialista);
		List<LocalDate> respuesta = new ArrayList<>();
		
		//Act
		ServicioMostrarDiasAgendables servicioMostrarDiasAgendables = new ServicioMostrarDiasAgendables(repositorioEspecialista);
		diasAgendablesSinFinesDeSemana(respuesta, 3);

		assertEquals(3, dtoEspecialista.getMaximoDiasAgendables());
		//Assert
		assertEquals(respuesta, servicioMostrarDiasAgendables.ejecutar(3L));
	}
	
	void diasAgendablesSinFinesDeSemana(List<LocalDate> fechas, int dias) {
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
