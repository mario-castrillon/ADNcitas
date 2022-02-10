package com.ceiba.especialista.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEspecialista {
	
	private Long idEspecialista;
	private String nombreEspecialista;
	private String especialidad;
	private int tarifa;
	private int maximoDiasAgendables;

}
