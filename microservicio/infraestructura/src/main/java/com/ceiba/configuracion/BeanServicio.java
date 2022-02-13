package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.ServicioActualizarCita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import com.ceiba.cita.servicio.ServicioEliminarCita;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.especialista.servicio.ServicioCrearEspecialista;
import com.ceiba.especialista.servicio.ServicioEliminarEspecialista;
import com.ceiba.especialista.servicio.ServicioMostrarDiasAgendables;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;
import com.ceiba.paciente.servicio.ServicioCrearPaciente;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioMostrarDiasAgendables servicioMostrarDiasAgendables(RepositorioEspecialista repositorioEspecialista) {
		return new ServicioMostrarDiasAgendables(repositorioEspecialista);
	}
	
    @Bean
    public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita, RepositorioPaciente repositorioPaciente,
			RepositorioEspecialista repositorioEspecialista) {
    	return new ServicioCrearCita(repositorioCita, repositorioPaciente, repositorioEspecialista);
    }
    
    @Bean
    public ServicioEliminarCita servicioEliminarCita(RepositorioCita repositorioCita) {
    	return new ServicioEliminarCita(repositorioCita);
    }
	
    @Bean
    public ServicioActualizarCita servicioActualizarCita(RepositorioCita repositorioCita) {
    	return new ServicioActualizarCita(repositorioCita);
    }
    
    @Bean
	public ServicioCrearEspecialista servicioCrearEspecialista(RepositorioEspecialista repositorioEspecialista) {
		return new ServicioCrearEspecialista(repositorioEspecialista);
	}
	
	@Bean
	public ServicioEliminarEspecialista servicioEliminarEspecialista(RepositorioEspecialista repositorioEspecialista) {
		return new ServicioEliminarEspecialista(repositorioEspecialista);
	}
	
	@Bean
	public ServicioActualizarEspecialista servicioActualizarEspecialista(RepositorioEspecialista repositorioEspecialista) {
		return new ServicioActualizarEspecialista(repositorioEspecialista);
	}
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
