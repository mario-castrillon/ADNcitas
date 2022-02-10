package com.ceiba.paciente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.paciente.modelo.dto.DtoPaciente;

public class MapeoPaciente implements RowMapper<DtoPaciente>, MapperResult {

	@Override
	public DtoPaciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long idPaciente = resultSet.getLong("idPaciente");
		String nombrePaciente = resultSet.getString("nombrePaciente");
		String cedula = resultSet.getString("cedula");

		return new DtoPaciente(idPaciente, nombrePaciente, cedula);
	}
}
