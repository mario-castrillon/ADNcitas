package com.ceiba.paciente.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Paciente {
	
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PACIENTE =
									"Se debe ingresar el nombre del paciente";
	private static final String SE_DEBE_INGRESAR_LA_CEDULA_DEL_PACIENTE =
									"Se debe ingresar la cedula del paciente";
	
	private Long idPaciente;
	private String nombrePaciente;
	private String cedula;
	
	public Paciente(Long idPaciente, String nombrePaciente, String cedula) {
		
		validarObligatorio(nombrePaciente, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PACIENTE);
		validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DEL_PACIENTE);
		
		this.idPaciente = idPaciente;
		this.nombrePaciente = nombrePaciente;
		this.cedula = cedula;
	}
}