package com.ceiba.paciente.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.comando.manejador.ManejadorActualizarPaciente;
import com.ceiba.paciente.comando.manejador.ManejadorCrearPaciente;
import com.ceiba.paciente.comando.manejador.ManejadorEliminarPaciente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pacientes")
@Api(tags = { "Controlador comando paciente"})
public class ComandoControladorPaciente {
	
	private final ManejadorCrearPaciente manejadorCrearPaciente;
	private final ManejadorEliminarPaciente manejadorEliminarPaciente;
	private final ManejadorActualizarPaciente manejadorActualizarPaciente;
	
	@Autowired
	public ComandoControladorPaciente(ManejadorCrearPaciente manejadorCrearPaciente,
			ManejadorEliminarPaciente manejadorEliminarPaciente,
			ManejadorActualizarPaciente manejadorActualizarPaciente) {
		this.manejadorCrearPaciente = manejadorCrearPaciente;
		this.manejadorEliminarPaciente = manejadorEliminarPaciente;
		this.manejadorActualizarPaciente = manejadorActualizarPaciente;
	}
	
	@PostMapping
    @ApiOperation("Crear Paciente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPaciente comandoPaciente) {
        return manejadorCrearPaciente.ejecutar(comandoPaciente);
    }
	
	@DeleteMapping(value="/{idPaciente}")
	@ApiOperation("Eliminar Paciente")
	public void eliminar(@PathVariable Long idPaciente) {
		manejadorEliminarPaciente.ejecutar(idPaciente);
	}
	
	@PutMapping(value="/{idPaciente}")
	@ApiOperation("Actualizar Paciente")
	public void actualizar(@RequestBody ComandoPaciente comandoPaciente, @PathVariable Long idPaciente) {
		comandoPaciente.setIdPaciente(idPaciente);
		manejadorActualizarPaciente.ejecutar(comandoPaciente);
	}

}
