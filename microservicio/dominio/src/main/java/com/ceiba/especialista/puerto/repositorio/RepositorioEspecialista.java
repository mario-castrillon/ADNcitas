package com.ceiba.especialista.puerto.repositorio;

import com.ceiba.especialista.modelo.entidad.Especialista;

public interface RepositorioEspecialista {

	Long crear(Especialista especialista);
	void actualizar(Especialista especialista);
	void eliminar(Long idEspecialista);
	boolean existe(String nombre);
	boolean existePorId(Long idEspecialista);
}