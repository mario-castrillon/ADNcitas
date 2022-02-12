package com.ceiba.cita.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioCrearCita {
	
	private static final String EXISTE_UNA_CITA_CON_ESA_FECHA =
									"Existe una cita con esa fecha";
	private static final String EL_PACIENTE_NO_EXISTE =
									"El paciente no existe";
	private static final String EL_ESPECIALISTA_NO_EXISTE =
									"El especialista no existe";
	
	private static final String EL_DIA_INGRESADO_NO_SE_PUEDE_AGENDAR =
			"El dia ingresado no se puede agendar";
	
	private final RepositorioCita repositorioCita;
	private final RepositorioPaciente repositorioPaciente;
	private final RepositorioEspecialista repositorioEspecialista;

	public ServicioCrearCita(RepositorioCita repositorioCita, RepositorioPaciente repositorioPaciente,
			RepositorioEspecialista repositorioEspecialista) {
		this.repositorioCita = repositorioCita;
		this.repositorioPaciente = repositorioPaciente;
		this.repositorioEspecialista = repositorioEspecialista;
	}

	public Long ejecutar(Cita cita) {
		
		validarExistenciaPaciente(cita);
		validarExistenciaEspecialista(cita);
		validarExistenciaPorFecha(cita);
		validarSiLaFechaEstaEnRangoAgendable(cita.getFecha(), cita.getIdEspecialista());
		return this.repositorioCita.crear(cita);
	}
	
	private void validarExistenciaPorFecha(Cita cita) {
		boolean existe = this.repositorioCita.existePorFecha(cita.getFecha());
		if(existe) {
			throw new ExcepcionDuplicidad(EXISTE_UNA_CITA_CON_ESA_FECHA);
		}
	}
	
	private void validarExistenciaPaciente(Cita cita) {
		boolean existe = this.repositorioPaciente.existePorId(cita.getIdPaciente());
		if(!existe) {
			throw new ExcepcionValorInvalido(EL_PACIENTE_NO_EXISTE);
		}
	}
	
	private void validarExistenciaEspecialista(Cita cita) {
		boolean existe = this.repositorioEspecialista.existePorId(cita.getIdEspecialista());
		if(!existe) {
			throw new ExcepcionValorInvalido(EL_ESPECIALISTA_NO_EXISTE);
		}
	}
	
	
	private void validarSiLaFechaEstaEnRangoAgendable(LocalDateTime fecha, Long idEspecialista) {
		
		LocalDate fechaSinHora = fecha.toLocalDate();
		List<LocalDate> diasAgendables = new ArrayList<>();
		DtoEspecialista especialista = repositorioEspecialista.obtener(idEspecialista);
		
		diasAgendablesSinFinesDeSemana(diasAgendables, especialista.getMaximoDiasAgendables());
		
		if(!diasAgendables.contains(fechaSinHora)) {
			throw new ExcepcionValorInvalido(EL_DIA_INGRESADO_NO_SE_PUEDE_AGENDAR);
		}
	}
	
	private void diasAgendablesSinFinesDeSemana(List<LocalDate> fechas, int dias) {
		int diasAgregados = 0;
		LocalDate temporal = LocalDate.now();

		while (diasAgregados < dias) {
			if (!(temporal.plusDays(1).getDayOfWeek() == DayOfWeek.SATURDAY
					|| temporal.plusDays(1).getDayOfWeek() == DayOfWeek.SUNDAY)) {
				fechas.add(temporal.plusDays(1));
				diasAgregados++;
			}
			temporal = temporal.plusDays(1);
		}
	}
}