package com.ceiba.paciente.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;

@Component
public class DaoPacienteMysql implements DaoPaciente {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	@SqlStatement(namespace="paciente", value="listar")
	private static String sqlListar;
	
	public DaoPacienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}
	
	@Override
	public List<DtoPaciente> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
					.query(sqlListar, new MapeoPaciente());
	}
}

