package com.ceiba.especialista.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoEspecialistaMysql implements DaoEspecialista {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace = "especialista", value = "listar")
	private static String sqlListar;
	
	@SqlStatement(namespace = "especialista", value = "listarPorId")
	private static String sqlListarPorId;

	public DaoEspecialistaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoEspecialista> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.query(sqlListar, new MapeoEspecialista());
	}

	@Override
	public List<DtoEspecialista> listarPorId(Long idEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("idEspecialista", idEspecialista);
	    
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.query(sqlListarPorId, paramSource, new MapeoEspecialista());
	}
	
	@Override
	public DtoEspecialista obtener(Long idEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEspecialista", idEspecialista);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
        		.queryForObject(sqlListarPorId,paramSource, new MapeoEspecialista());
	}
}
