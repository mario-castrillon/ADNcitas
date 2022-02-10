package com.ceiba.paciente.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;

@Component
public class ManejadorListarPacientes {

	private final DaoPaciente daoPaciente;

	public ManejadorListarPacientes(DaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}

	public List<DtoPaciente> ejecutar() {
		return this.daoPaciente.listar();
	}
}
