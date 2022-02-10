package com.ceiba.especialista.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;

@Component
public class FabricaEspecialista {
	
	public Especialista crear(ComandoEspecialista comandoEspecialista) {
		return new Especialista(
				comandoEspecialista.getIdEspecialista(),
				comandoEspecialista.getNombreEspecialista(),
				comandoEspecialista.getEspecialidad(),
				comandoEspecialista.getTarifa(),
				comandoEspecialista.getMaximoDiasAgendables()
				);
	}

}


