package com.ceiba.cita.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCita {
	
	private Long id;
	private LocalDateTime fecha;
	private String nombrePaciente;
	private String cedula;
	private String nombreEspecialista;
	private String especialidad;
	private int tarifa;
}