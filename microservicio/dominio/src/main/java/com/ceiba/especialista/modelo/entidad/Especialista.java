package com.ceiba.especialista.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import lombok.Getter;

@Getter
public class Especialista {
	
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ESPECIALISTA = 
									"Se debe ingresar el nombre del especialista";
	private static final String SE_DEBE_INGRESAR_LA_ESPECIALIDAD =
									"Se debe ingresar la especialidad";
	private static final String SE_DEBE_INGRESAR_LA_TARIFA =
									"Se debe ingresar la tarifa";
	private static final String SE_DEBE_INGRESAR_EL_NUMERO_MAXIMO_DE_DIAS_AGENDABLES =
									"Se debe ingresar el numero maximo de dias agendables";
	
	private Long idEspecialista;
	private String nombreEspecialista;
	private String especialidad;
	private int tarifa;
	private int maximoDiasAgendables;
	
	public Especialista(Long idEspecialista, String nombreEspecialista, String especialidad, int tarifa, int maximoDiasAgendables) {
		
		validarObligatorio(nombreEspecialista, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_ESPECIALISTA);
		validarObligatorio(especialidad, SE_DEBE_INGRESAR_LA_ESPECIALIDAD);
		validarObligatorio(tarifa, SE_DEBE_INGRESAR_LA_TARIFA);
		validarObligatorio(maximoDiasAgendables, SE_DEBE_INGRESAR_EL_NUMERO_MAXIMO_DE_DIAS_AGENDABLES);
		
		this.idEspecialista = idEspecialista;
		this.nombreEspecialista = nombreEspecialista;
		this.especialidad = especialidad;
		this.tarifa = tarifa;
		this.maximoDiasAgendables = maximoDiasAgendables;
	}
}
