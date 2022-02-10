package com.ceiba.paciente.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;

@Component
public class ManejadorEliminarPaciente implements ManejadorComando<Long> {

	private final ServicioEliminarPaciente servicioEliminarPaciente;

	public ManejadorEliminarPaciente(ServicioEliminarPaciente servicioEliminarPaciente) {
		this.servicioEliminarPaciente = servicioEliminarPaciente;
	}

	@Override
	public void ejecutar(Long idPaciente) {
		this.servicioEliminarPaciente.ejecutar(idPaciente);

	}
}
