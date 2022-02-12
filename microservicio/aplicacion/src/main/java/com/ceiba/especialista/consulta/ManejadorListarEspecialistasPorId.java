package com.ceiba.especialista.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

//import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;

@Component
public class ManejadorListarEspecialistasPorId {
	private final DaoEspecialista daoEspecialista;
	
	private static final String NO_HAY_ESPECIALISTAS_CON_EL_ID_INGRESADO = "No hay especialistas con el id ingresado";

	public ManejadorListarEspecialistasPorId(DaoEspecialista daoEspecialista) {
		this.daoEspecialista = daoEspecialista;
	}

	public List<DtoEspecialista> ejecutar(Long idEspecialista) {
		
		List<DtoEspecialista> respuesta = this.daoEspecialista.listarPorId(idEspecialista);

		/*
		if(respuesta.isEmpty()) {
			throw new ExcepcionSinDatos(NO_HAY_ESPECIALISTAS_CON_EL_ID_INGRESADO);
		}
		*/
		
		return respuesta;
	}
}
