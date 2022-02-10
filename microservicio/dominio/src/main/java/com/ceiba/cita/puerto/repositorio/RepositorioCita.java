package com.ceiba.cita.puerto.repositorio;

import java.time.LocalDateTime;

import com.ceiba.cita.modelo.entidad.Cita;

public interface RepositorioCita {

	Long crear(Cita cita);
	void actualizar(Cita cita);
	void eliminar(Long id);
	boolean existePorId(Long id);
	boolean existePorFecha(LocalDateTime fecha);
}