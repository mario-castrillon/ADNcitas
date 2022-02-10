package com.ceiba.cita.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.cita.puerto.dao.DaoCita;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

@Component
public class ManejadorListarCitasPorEspecialistaId {
	
	private final DaoCita daoCita;
	private static final String NO_HAY_CITAS_PARA_ESE_ESPECIALISTA =
			"No hay citas para ese especialista";

	public ManejadorListarCitasPorEspecialistaId(DaoCita daoCita) {
		this.daoCita = daoCita;
	}

	public List<DtoCita> ejecutar(Long idEspecialista) {
		List<DtoCita> respuesta = this.daoCita.listarPorEspecialistaId(idEspecialista);
		if(respuesta.isEmpty()) {
			throw new ExcepcionSinDatos(NO_HAY_CITAS_PARA_ESE_ESPECIALISTA);
		}
		return respuesta;
	}
}
