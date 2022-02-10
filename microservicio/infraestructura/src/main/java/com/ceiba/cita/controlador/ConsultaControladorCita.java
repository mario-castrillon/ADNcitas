package com.ceiba.cita.controlador;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cita.consulta.ManejadorListarCitas;
import com.ceiba.cita.consulta.ManejadorListarCitasPorEspecialistaId;
import com.ceiba.cita.consulta.ManejadorListarCitasPorFecha;
import com.ceiba.cita.modelo.dto.DtoCita;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(tags={"Controlador consulta cita"})
public class ConsultaControladorCita {
	
	private final ManejadorListarCitas manejadorListarCitas;
	private final ManejadorListarCitasPorEspecialistaId manejadorListarCitasPorEspecialistaId;
	private final ManejadorListarCitasPorFecha manejadorListarCitasPorFecha;

	public ConsultaControladorCita(ManejadorListarCitas manejadorListarCitas,
			ManejadorListarCitasPorEspecialistaId manejadorListarCitasPorEspecialistaId,
			ManejadorListarCitasPorFecha manejadorListarCitasPorFecha) {
		this.manejadorListarCitas = manejadorListarCitas;
		this.manejadorListarCitasPorEspecialistaId = manejadorListarCitasPorEspecialistaId;
		this.manejadorListarCitasPorFecha = manejadorListarCitasPorFecha;
	}

	@GetMapping
	@ApiOperation("Listar Citas")
	public List<DtoCita> listar(){
		return this.manejadorListarCitas.ejecutar();
	}
	
	@GetMapping(value="especialista/{idEspecialista}")
	@ApiOperation("Listar Citas Por Id de Especialista")
	public List<DtoCita> listarCitasPorEspecialistaId(@PathVariable Long idEspecialista){
		return this.manejadorListarCitasPorEspecialistaId.ejecutar(idEspecialista);
	}
	
	@GetMapping(value="fecha/{fecha}")
	@ApiOperation("Listar Citas Por Fecha")
	public List<DtoCita> listarCitasPorFecha(@PathVariable("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha){
		return this.manejadorListarCitasPorFecha.ejecutar(fecha);
	}
}