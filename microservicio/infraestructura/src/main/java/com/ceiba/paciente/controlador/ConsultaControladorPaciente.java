package com.ceiba.paciente.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.paciente.consulta.ManejadorListarPacientes;
import com.ceiba.paciente.modelo.dto.DtoPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pacientes")
@Api(tags={"Controlador consulta paciente"})
public class ConsultaControladorPaciente {
	
	private final ManejadorListarPacientes manejadorListarPacientes;

	public ConsultaControladorPaciente(ManejadorListarPacientes manejadorListarPacientes) {
		this.manejadorListarPacientes = manejadorListarPacientes;
	}
	
	@GetMapping
	@ApiOperation("Listar Pacientes")
	public List<DtoPaciente> listar(){
		return this.manejadorListarPacientes.ejecutar();
	}
}
