package com.ceiba.paciente.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.modelo.entidad.Paciente;

@Component
public class FabricaPaciente {

	public Paciente crear(ComandoPaciente comandoPaciente) {
		return new Paciente(
						comandoPaciente.getIdPaciente(),
						comandoPaciente.getNombrePaciente(),
						comandoPaciente.getCedula()
					);
	}
}
