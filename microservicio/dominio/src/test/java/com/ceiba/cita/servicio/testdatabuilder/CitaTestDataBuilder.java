package com.ceiba.cita.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.cita.modelo.entidad.Cita;

public class CitaTestDataBuilder {
	
	private Long id;
	private Long idPaciente;
	private Long idEspecialista;
	private LocalDateTime fecha;
	
	public CitaTestDataBuilder() {
		this.idPaciente = 6L;
		this.idEspecialista = 9L;
		this.fecha = LocalDateTime.of(2022, 3, 3, 15, 0, 0);
	}
	
	public CitaTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public CitaTestDataBuilder conIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
		return this;
	}
	
	public CitaTestDataBuilder conIdEspecialista(Long idEspecialista) {
		this.idEspecialista = idEspecialista;
		return this;
	}
	
	public CitaTestDataBuilder conFecha(LocalDateTime fecha) {
		this.fecha = fecha;
		return this;
	}
	
	public Cita build() {
		return new Cita(id, idPaciente, idEspecialista, fecha);
	}
}
