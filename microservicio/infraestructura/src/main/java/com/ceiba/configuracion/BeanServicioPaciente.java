package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;
import com.ceiba.paciente.servicio.ServicioCrearPaciente;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;

@Configuration
public class BeanServicioPaciente {
	
	@Bean
	public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
		return new ServicioCrearPaciente(repositorioPaciente);
	}
	
	@Bean
	public ServicioEliminarPaciente servicioEliminarPaciente(RepositorioPaciente repositorioPaciente) {
		return new ServicioEliminarPaciente(repositorioPaciente);
	}
	
	@Bean
	public ServicioActualizarPaciente servicioActualizarPaciente(RepositorioPaciente repositorioPaciente) {
		return new ServicioActualizarPaciente(repositorioPaciente);
	}
}
