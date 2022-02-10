package com.ceiba.cita.puerto.dao;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.cita.modelo.dto.DtoCita;

public interface DaoCita {
	
	List<DtoCita> listar();
	List<DtoCita> listarPorEspecialistaId(Long idEspecialista);
	List<DtoCita> listarPorFecha(LocalDate fecha);
}