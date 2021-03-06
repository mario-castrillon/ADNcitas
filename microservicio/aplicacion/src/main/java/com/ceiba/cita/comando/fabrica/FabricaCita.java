package com.ceiba.cita.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;

@Component
public class FabricaCita {
	
	public Cita crear(ComandoCita comandoCita) {
		return new Cita(
				comandoCita.getId(),
				comandoCita.getIdPaciente(),
				comandoCita.getIdEspecialista(),
				comandoCita.getFecha()
		);
	}
}
