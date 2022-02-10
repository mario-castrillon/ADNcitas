package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.modelo.entidad.Paciente;

public class PacienteTestDataBuilder {
	
	private Long idPaciente;
	private String nombrePaciente;
	private String cedula;
	
	public PacienteTestDataBuilder() {
		this.nombrePaciente = "Nombre Paciente";
		this.cedula = "123456789";
	}
	
	public PacienteTestDataBuilder conId(Long id) {
		this.idPaciente = id;
		return this;
	}
	
	public PacienteTestDataBuilder conNombre(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
		return this;
	}
	
	public PacienteTestDataBuilder conCedula(String cedula) {
		this.cedula = cedula;
		return this;
	}
	
	public Paciente build() {
		return new Paciente(idPaciente, nombrePaciente, cedula);
	}
}
