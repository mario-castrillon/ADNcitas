package com.ceiba.especialista.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoEspecialista implements RowMapper<DtoEspecialista>, MapperResult {

	@Override
	public DtoEspecialista mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		Long idEspecialista = resultSet.getLong("idEspecialista");
        String nombreEspecialista = resultSet.getString("nombreEspecialista");
        String clave = resultSet.getString("especialidad");
        int tarifa = resultSet.getInt("tarifa");
        int maximoDiasAgendables = resultSet.getInt("maximoDiasAgendables");
		
		return new DtoEspecialista(idEspecialista, nombreEspecialista, clave, tarifa, maximoDiasAgendables);
	}
}
