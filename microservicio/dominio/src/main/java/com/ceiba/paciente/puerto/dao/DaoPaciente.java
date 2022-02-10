package com.ceiba.paciente.puerto.dao;

import java.util.List;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

public interface DaoPaciente {
	
	List<DtoPaciente> listar();
}
