package com.ceiba.cita.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {
	
	private Long id;
	private Long idPaciente;
	private Long idEspecialista;
	private LocalDateTime fecha;
}
