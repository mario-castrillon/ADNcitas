package com.ceiba.especialista.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.comando.manejador.ManejadorActualizarEspecialista;
import com.ceiba.especialista.comando.manejador.ManejadorCrearEspecialista;
import com.ceiba.especialista.comando.manejador.ManejadorEliminarEspecialista;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/especialistas")
@Api(tags = { "Controlador comando especialista"})
public class ComandoControladorEspecialista {
	
	private final ManejadorCrearEspecialista manejadorCrearEspecialista;
	private final ManejadorEliminarEspecialista manejadorEliminarEspecialista;
	private final ManejadorActualizarEspecialista manejadorActualizarEspecialista;
	
	@Autowired
	public ComandoControladorEspecialista(ManejadorCrearEspecialista manejadorCrearEspecialista,
			ManejadorEliminarEspecialista manejadorEliminarEspecialista,
			ManejadorActualizarEspecialista manejadorActualizarEspecialista) {
		this.manejadorCrearEspecialista = manejadorCrearEspecialista;
		this.manejadorEliminarEspecialista = manejadorEliminarEspecialista;
		this.manejadorActualizarEspecialista = manejadorActualizarEspecialista;
	}
	
	@PostMapping
    @ApiOperation("Crear Especialista")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspecialista comandoEspecialista) {
        return manejadorCrearEspecialista.ejecutar(comandoEspecialista);
    }
	
	@DeleteMapping(value="/{idEspecialista}")
	@ApiOperation("Eliminar Especialista")
	public void eliminar(@PathVariable Long idEspecialista) {
		manejadorEliminarEspecialista.ejecutar(idEspecialista);
	}
	
	@PutMapping(value="/{idEspecialista}")
	@ApiOperation("Actualizar Especialista")
	public void actualizar(@RequestBody ComandoEspecialista comandoEspecialista, @PathVariable Long idEspecialista) {
		comandoEspecialista.setIdEspecialista(idEspecialista);
		manejadorActualizarEspecialista.ejecutar(comandoEspecialista);
	}
}
