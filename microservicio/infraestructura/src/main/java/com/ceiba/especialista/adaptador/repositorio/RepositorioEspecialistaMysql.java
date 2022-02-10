package com.ceiba.especialista.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioEspecialistaMysql implements RepositorioEspecialista {
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "especialista", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "especialista", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "especialista", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "especialista", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "especialista", value = "existePorId")
	private static String sqlExistePorId;

	public RepositorioEspecialistaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Especialista especialista) {
		return this.customNamedParameterJdbcTemplate.crear(especialista, sqlCrear);
	}

	@Override
	public void actualizar(Especialista especialista) {
		this.customNamedParameterJdbcTemplate.actualizar(especialista, sqlActualizar);
	}

	@Override
	public void eliminar(Long idEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEspecialista", idEspecialista);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
	}

	@Override
	public boolean existe(String nombreEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombreEspecialista", nombreEspecialista);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public boolean existePorId(Long idEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEspecialista", idEspecialista);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
	}

}
