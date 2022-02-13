package com.ceiba.cita.adaptador.repositorio;

import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioCitaMysql implements RepositorioCita {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "cita", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "cita", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "cita", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "cita", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "cita", value = "existePorId")
	private static String sqlExistePorId;

	public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
	        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	    }

	@Override
	public Long crear(Cita cita) {
		return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
	}

	@Override
	public void eliminar(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);

		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public void actualizar(Cita cita) {
		this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
	} 

	@Override
	public boolean existePorId(Long id) {
		return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlExistePorId,
				new MapSqlParameterSource().addValue("id", id), Boolean.class));
	}

	@Override
	public boolean existePorFecha(LocalDateTime fecha) {
		return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate
				.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,
						new MapSqlParameterSource().addValue("fecha", fecha), Boolean.class));
	}

}
