package com.ceiba.especialista.servicio.testdatabuilder;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;

public class EspecialistaDtoTestDataBuilder {
	
	private Long idEspecialista;
	private String nombreEspecialista;
	private String especialidad;
	private int tarifa;
	private int maximoDiasAgendables;
	
	public EspecialistaDtoTestDataBuilder() {
		nombreEspecialista = "Nombre Especialista";
		especialidad = "Especialidad";
		tarifa = 123000;
		maximoDiasAgendables = 6;
	}
	
	public EspecialistaDtoTestDataBuilder conId(Long id) {
		this.idEspecialista = id;
		return this;
	}
	
	public EspecialistaDtoTestDataBuilder conNombre(String nombre) {
		this.nombreEspecialista = nombre;
		return this;
	}
	
	public EspecialistaDtoTestDataBuilder conEspecialidad(String especialidad) {
		this.especialidad = especialidad;
		return this;
	}
	
	public EspecialistaDtoTestDataBuilder conTarifa(int tarifa) {
		this.tarifa = tarifa;
		return this;
	}
	
	public EspecialistaDtoTestDataBuilder conMaximoDiasAgendables(int maximoDiasAgendables) {
		this.maximoDiasAgendables = maximoDiasAgendables;
		return this;
	}
	
	public DtoEspecialista build() {
		return new DtoEspecialista(idEspecialista, nombreEspecialista, especialidad, tarifa, maximoDiasAgendables);
	}
}
