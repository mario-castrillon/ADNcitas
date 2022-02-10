package com.ceiba.paciente.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

@Repository
public class RepositorioPacienteMysql implements RepositorioPaciente {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "paciente", value = "crear")
	private static String sqlCrear;

	@SqlStatement(namespace = "paciente", value = "actualizar")
	private static String sqlActualizar;

	@SqlStatement(namespace = "paciente", value = "eliminar")
	private static String sqlEliminar;

	@SqlStatement(namespace = "paciente", value = "existe")
	private static String sqlExiste;

	@SqlStatement(namespace = "paciente", value = "existePorId")
	private static String sqlExistePorId;

	public RepositorioPacienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Paciente paciente) {
		return this.customNamedParameterJdbcTemplate.crear(paciente, sqlCrear);
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.customNamedParameterJdbcTemplate.actualizar(paciente, sqlActualizar);
		
	}

	@Override
	public void eliminar(Long idPaciente) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("idPaciente", idPaciente);
		
		this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
			.update(sqlEliminar, parameterSource);
	}

	@Override
	public boolean existe(String nombrePaciente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombrePaciente", nombrePaciente);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
        			.queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public boolean existePorId(Long idPaciente) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPaciente", idPaciente);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
        		.queryForObject(sqlExistePorId,paramSource, Boolean.class);
	}
}
