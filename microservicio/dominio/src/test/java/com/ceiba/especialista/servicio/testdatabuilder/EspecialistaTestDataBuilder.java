package com.ceiba.especialista.servicio.testdatabuilder;

import com.ceiba.especialista.modelo.entidad.Especialista;

public class EspecialistaTestDataBuilder {
	
	private Long idEspecialista;
	private String nombreEspecialista;
	private String especialidad;
	private int tarifa;
	private int maximoDiasAgendables;
	
	public EspecialistaTestDataBuilder() {
		nombreEspecialista = "Nombre Especialista";
		especialidad = "Especialidad";
		tarifa = 123000;
		maximoDiasAgendables = 6;
	}
	
	public EspecialistaTestDataBuilder conId(Long id) {
		this.idEspecialista = id;
		return this;
	}
	
	public EspecialistaTestDataBuilder conNombre(String nombre) {
		this.nombreEspecialista = nombre;
		return this;
	}
	
	public EspecialistaTestDataBuilder conEspecialidad(String especialidad) {
		this.especialidad = especialidad;
		return this;
	}
	
	public EspecialistaTestDataBuilder conTarifa(int tarifa) {
		this.tarifa = tarifa;
		return this;
	}
	
	public EspecialistaTestDataBuilder conMaximoDiasAgendables(int maximoDiasAgendables) {
		this.maximoDiasAgendables = maximoDiasAgendables;
		return this;
	}
	
	public Especialista build() {
		return new Especialista(idEspecialista, nombreEspecialista, especialidad, tarifa, maximoDiasAgendables);
	}
}
