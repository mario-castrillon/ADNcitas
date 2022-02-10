package com.ceiba.especialista.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoEspecialista {
	
	private Long idEspecialista;
	private String nombreEspecialista;
	private String especialidad;
	private int tarifa;
	private int maximoDiasAgendables;
}
