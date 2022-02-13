package com.ceiba.especialista.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

//import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;

@Component
public class ManejadorListarEspecialistasPorId {
	private final DaoEspecialista daoEspecialista;
	
	public ManejadorListarEspecialistasPorId(DaoEspecialista daoEspecialista) {
		this.daoEspecialista = daoEspecialista;
	}

	public List<DtoEspecialista> ejecutar(Long idEspecialista) {
		return this.daoEspecialista.listarPorId(idEspecialista);
	}
}
