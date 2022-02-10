package com.ceiba.especialista.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.especialista.comando.manejador.ManejadorMostrarDiasAgendables;
import com.ceiba.especialista.consulta.ManejadorListarEspecialistas;
import com.ceiba.especialista.consulta.ManejadorListarEspecialistasPorId;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/especialistas")
@Api(tags={"Controlador consulta especialista"})
public class ConsultaControladorEspecialista {
	
	private final ManejadorListarEspecialistas manejadorListarEspecialistas;
	private final ManejadorListarEspecialistasPorId manejadorListarEspecialistasPorId;
	private final ManejadorMostrarDiasAgendables manejadorMostrarDiasAgendables;
	
	public ConsultaControladorEspecialista(ManejadorListarEspecialistas manejadorListarEspecialistas,
			ManejadorListarEspecialistasPorId manejadorListarEspecialistasPorId,
			ManejadorMostrarDiasAgendables manejadorMostrarDiasAgendables) {
		this.manejadorListarEspecialistas = manejadorListarEspecialistas;
		this.manejadorListarEspecialistasPorId = manejadorListarEspecialistasPorId;
		this.manejadorMostrarDiasAgendables = manejadorMostrarDiasAgendables;
	}
	
	@GetMapping
	@ApiOperation("Listar Especialistas")
	public List<DtoEspecialista> listar(){
		return this.manejadorListarEspecialistas.ejecutar();
	}
	
	@GetMapping(value="/{idEspecialista}")
	@ApiOperation("Listar Especialistas Por Id")
	public List<DtoEspecialista> listarPorEspecialista(@PathVariable Long idEspecialista){
		return this.manejadorListarEspecialistasPorId.ejecutar(idEspecialista);
	}
	
	@GetMapping(value="/{idEspecialista}/agendables")
	@ApiOperation("Listar Especialistas Por Id")
	public List<LocalDate> listarDiasAgendablesPorEspecialista(@PathVariable Long idEspecialista){
		return this.manejadorMostrarDiasAgendables.ejecutar(idEspecialista);
	}
}
