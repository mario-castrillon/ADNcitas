package com.ceiba.especialista.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;

@Component
public class ManejadorListarEspecialistas {

	private final DaoEspecialista daoEspecialista;

	public ManejadorListarEspecialistas(DaoEspecialista daoEspecialista) {
		this.daoEspecialista = daoEspecialista;
	}

	public List<DtoEspecialista> ejecutar() {
		return this.daoEspecialista.listar();
	}
}
