package com.ceiba.cita.consulta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;

@Component
public class ManejadorListarCitasPorFecha {

	private final DaoCita daoCita;

	public ManejadorListarCitasPorFecha(DaoCita daoCita) {
		this.daoCita = daoCita;
	}

	public List<DtoCita> ejecutar(LocalDate fecha) {
		return this.daoCita.listarPorFecha(fecha);
	}
}
