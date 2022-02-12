package com.ceiba.cita.consulta;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
//import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

@Component
public class ManejadorListarCitasPorFecha {

	private final DaoCita daoCita;
	private static final String NO_HAY_CITAS_PARA_ESA_FECHA = "No hay citas para esa fecha";

	public ManejadorListarCitasPorFecha(DaoCita daoCita) {
		this.daoCita = daoCita;
	}

	public List<DtoCita> ejecutar(LocalDate fecha) {
		List<DtoCita> respuesta = this.daoCita.listarPorFecha(fecha);

		/*
		if (respuesta.isEmpty()) {
			throw new ExcepcionSinDatos(NO_HAY_CITAS_PARA_ESA_FECHA);
		}
		 */
		return respuesta;
	}
}
