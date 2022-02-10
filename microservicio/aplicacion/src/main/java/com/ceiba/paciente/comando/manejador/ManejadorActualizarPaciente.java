package com.ceiba.paciente.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.comando.fabrica.FabricaPaciente;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;

@Component
public class ManejadorActualizarPaciente implements ManejadorComando<ComandoPaciente> {

	private final FabricaPaciente fabricaPaciente;
	private final ServicioActualizarPaciente servicioActualizarPaciente;

	public ManejadorActualizarPaciente(FabricaPaciente fabricaPaciente,
			ServicioActualizarPaciente servicioActualizarPaciente) {
		this.fabricaPaciente = fabricaPaciente;
		this.servicioActualizarPaciente = servicioActualizarPaciente;
	}
	
	@Override
	public void ejecutar(ComandoPaciente comandoPaciente) {
		Paciente paciente = this.fabricaPaciente.crear(comandoPaciente);
		this.servicioActualizarPaciente.ejecutar(paciente);
	}
}
