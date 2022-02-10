package com.ceiba.especialista.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.especialista.servicio.ServicioEliminarEspecialista;

@Component
public class ManejadorEliminarEspecialista {
	
	private final ServicioEliminarEspecialista servicioEliminarEspecialista;

	public ManejadorEliminarEspecialista(ServicioEliminarEspecialista servicioEliminarEspecialista) {
		this.servicioEliminarEspecialista = servicioEliminarEspecialista;
	}
	
	public void ejecutar(Long idEspecialista) {
		this.servicioEliminarEspecialista.ejecutar(idEspecialista);
	}
}
