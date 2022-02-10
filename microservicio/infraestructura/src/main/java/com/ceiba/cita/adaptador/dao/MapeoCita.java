package com.ceiba.cita.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

	@Override
	public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Long id = resultSet.getLong("id");
		LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
		String nombrePaciente = resultSet.getString("nombrePaciente");
		String cedula = resultSet.getString("cedula");
		String nombreEspecialista = resultSet.getString("nombreEspecialista");
		String especialidad = resultSet.getString("especialidad");
		int tarifa = resultSet.getInt("tarifa");
		
		return new DtoCita(id, fecha, nombrePaciente, cedula, nombreEspecialista, especialidad, tarifa);
	}
}
