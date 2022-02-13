package com.ceiba.cita.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarMayorHora;
import static com.ceiba.dominio.ValidadorArgumento.validarMayor;
import static com.ceiba.dominio.ValidadorArgumento.validarMenorHora;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Getter;

@Getter
public class Cita {
	
	private static final String SE_DEBE_INGRESAR_ID_DEL_PACIENTE =
									"Se debe ingresar el paciente";
	private static final String SE_DEBE_INGRESAR_EL_ID_DEL_ESPECIALISTA =
									"Se debe ingresar el especialista";
	private static final String SE_DEBE_INGRESAR_LA_FECHA =
									"Se debe ingresar la fecha";
	private static final String DEBE_SER_HORA_MAYOR_DE_LAS_8 =
			"La hora debe ser mayor o igual a las 8";
	private static final String DEBE_SER_HORA_MENOR_DE_LAS_17 =
			"La hora debe ser menor o igual a las 17";
	private static final String DEBE_SER_FECHA_SUPERIOR_A_HOY =
			"La fecha debe ser superior a la de hoy";

	private Long id;
	private Long idPaciente;
	private Long idEspecialista;
	private LocalDateTime fecha;
	
	public Cita(Long id, Long idPaciente, Long idEspecialista, LocalDateTime fecha) {
		
		validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA);
		validarMayor(fecha, LocalDateTime.now().plusDays(1), DEBE_SER_FECHA_SUPERIOR_A_HOY);
		validarMenorHora(fecha, LocalTime.of(8, 0,0), DEBE_SER_HORA_MAYOR_DE_LAS_8);
		validarMayorHora(fecha, LocalTime.of(17,0,0), DEBE_SER_HORA_MENOR_DE_LAS_17);
		validarObligatorio(idPaciente, SE_DEBE_INGRESAR_ID_DEL_PACIENTE);
		validarObligatorio(idEspecialista,
				SE_DEBE_INGRESAR_EL_ID_DEL_ESPECIALISTA);
		
		this.id = id;
		this.idPaciente = idPaciente;
		this.idEspecialista = idEspecialista;
		this.fecha = fecha;
	}
}