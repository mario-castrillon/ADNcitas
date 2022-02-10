package com.ceiba.paciente.puerto.repositorio;

import com.ceiba.paciente.modelo.entidad.Paciente;

public interface RepositorioPaciente {
	
	Long crear(Paciente paciente);
	void actualizar(Paciente paciente);
	void eliminar(Long idPaciente);
	boolean existe(String nombrePaciente);
	boolean existePorId(Long idPaciente);
}