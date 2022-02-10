package com.ceiba.especialista.puerto.dao;

import java.util.List;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;

public interface DaoEspecialista {
	
	List<DtoEspecialista> listar();
	List<DtoEspecialista> listarPorId(Long idEspecialista);
	DtoEspecialista obtener(Long idEspecialista);
}
