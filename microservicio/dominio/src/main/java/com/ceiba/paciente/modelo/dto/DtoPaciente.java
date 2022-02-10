package com.ceiba.paciente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPaciente {
	private Long idPaciente;
	private String nombrePaciente;
	private String cedula;

}
