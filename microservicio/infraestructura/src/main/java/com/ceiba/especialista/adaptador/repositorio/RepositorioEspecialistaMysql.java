package com.ceiba.especialista.adaptador.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.especialista.adaptador.dao.MapeoEspecialista;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
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
	
	@SqlStatement(namespace = "especialista", value = "obtener")
	private static String sqlObtener;

	@Autowired
	private static final String idEspecialista = "idEspecialista";

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
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,
									new MapSqlParameterSource().addValue(this.idEspecialista, idEspecialista));
	}

	@Override
	public boolean existe(String nombreEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombreEspecialista", nombreEspecialista);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class));
	}

	@Override
	public boolean existePorId(Long idEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(this.idEspecialista, idEspecialista);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class));
	}

	@Override
	public DtoEspecialista obtener(Long idEspecialista) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(this.idEspecialista, idEspecialista);
		
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, paramSource, new MapeoEspecialista());
	}

}
