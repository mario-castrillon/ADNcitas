package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.especialista.servicio.ServicioCrearEspecialista;
import com.ceiba.especialista.servicio.ServicioEliminarEspecialista;

@Configuration
public class BeanServicioEspecialista {
	
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
}
