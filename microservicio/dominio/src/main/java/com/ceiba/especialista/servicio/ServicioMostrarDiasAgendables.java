package com.ceiba.especialista.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioMostrarDiasAgendables {

	private static final String EL_ESPECIALISTA_NO_TIENE_DIAS_AGENDABLES = "El especialista no tiene dias agendables";
	private static final String EL_ESPECIALISTA_NO_EXISTE = "El especialista no existe";

	private final RepositorioEspecialista repositorioEspecialista;

	public ServicioMostrarDiasAgendables(RepositorioEspecialista repositorioEspecialista) {
		this.repositorioEspecialista = repositorioEspecialista;
	}

	public List<LocalDate> ejecutar(Long idEspecialista) {

		if (!repositorioEspecialista.existePorId(idEspecialista)) {
			throw new ExcepcionSinDatos(EL_ESPECIALISTA_NO_EXISTE);
		}
	
		DtoEspecialista especialista = repositorioEspecialista.obtener(idEspecialista);
		List<LocalDate> respuesta = new ArrayList<>();
		int maximoDiasAgendables = especialista.getMaximoDiasAgendables();

		if (especialista.getMaximoDiasAgendables() == 0) {
			throw new ExcepcionSinDatos(EL_ESPECIALISTA_NO_TIENE_DIAS_AGENDABLES);
		}

		diasAgendablesSinFinesDeSemana(respuesta, maximoDiasAgendables);
		return respuesta;
	}

	private void diasAgendablesSinFinesDeSemana(List<LocalDate> fechas, int dias) {
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
		//return fechas;
	}
}
