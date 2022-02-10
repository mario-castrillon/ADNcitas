package com.ceiba.paciente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPaciente {
	
	private Long idPaciente;
	private String nombrePaciente;
	private String cedula;

}
