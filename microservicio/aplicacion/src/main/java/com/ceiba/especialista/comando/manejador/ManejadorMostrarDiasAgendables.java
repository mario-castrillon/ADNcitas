package com.ceiba.especialista.comando.manejador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.especialista.servicio.ServicioMostrarDiasAgendables;

@Component
public class ManejadorMostrarDiasAgendables {

	ServicioMostrarDiasAgendables servicioMostrarDiasAgendables;

	public ManejadorMostrarDiasAgendables(ServicioMostrarDiasAgendables servicioMostrarDiasAgendables) {
		this.servicioMostrarDiasAgendables = servicioMostrarDiasAgendables;
	}

	public List<LocalDate> ejecutar(Long idEspecialista) {
		return this.servicioMostrarDiasAgendables.ejecutar(idEspecialista);
	}
}
