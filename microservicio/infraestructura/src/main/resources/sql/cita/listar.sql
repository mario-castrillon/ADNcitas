SELECT cita.id, cita.fecha, paciente.nombrePaciente,
		paciente.cedula, especialista.nombreEspecialista,
		especialista.especialidad, especialista.tarifa
FROM ((cita
INNER JOIN paciente ON cita.idPaciente = paciente.idPaciente)
INNER JOIN especialista ON cita.idEspecialista = especialista.idEspecialista);