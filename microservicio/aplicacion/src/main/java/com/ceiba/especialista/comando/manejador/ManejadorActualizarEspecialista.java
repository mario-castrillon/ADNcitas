package com.ceiba.especialista.comando.manejador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarEspecialista implements ManejadorComando<ComandoEspecialista> {
	
	@Autowired
	private final FabricaEspecialista fabricaEspecialista;
	@Autowired
	private final ServicioActualizarEspecialista servicioActualizarEspecialista;

	public ManejadorActualizarEspecialista(FabricaEspecialista fabricaEspecialista,
			ServicioActualizarEspecialista servicioActualizarEspecialista) {
		this.fabricaEspecialista = fabricaEspecialista;
		this.servicioActualizarEspecialista = servicioActualizarEspecialista;
	}

	@Override
	public void ejecutar(ComandoEspecialista comandoEspecialista) {
		Especialista especialista = this.fabricaEspecialista.crear(comandoEspecialista);
		this.servicioActualizarEspecialista.ejecutar(especialista);

	}

}
