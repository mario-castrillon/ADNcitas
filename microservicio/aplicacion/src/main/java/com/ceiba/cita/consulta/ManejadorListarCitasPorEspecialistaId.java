package com.ceiba.cita.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;

@Component
public class ManejadorListarCitasPorEspecialistaId {
	
	private final DaoCita daoCita;

	public ManejadorListarCitasPorEspecialistaId(DaoCita daoCita) {
		this.daoCita = daoCita;
	}

	public List<DtoCita> ejecutar(Long idEspecialista) {
		return this.daoCita.listarPorEspecialistaId(idEspecialista);
	}
}
