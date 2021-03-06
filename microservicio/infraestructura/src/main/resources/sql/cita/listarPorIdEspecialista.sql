SELECT citasmedicas.cita.id, citasmedicas.cita.fecha, citasmedicas.paciente.nombrePaciente,
		citasmedicas.paciente.cedula, citasmedicas.especialista.nombreEspecialista,
		citasmedicas.especialista.especialidad, citasmedicas.especialista.tarifa
FROM ((citasmedicas.cita
INNER JOIN citasmedicas.paciente ON (citasmedicas.cita.idPaciente = citasmedicas.paciente.idPaciente AND citasmedicas.cita.idEspecialista = :idEspecialista))
INNER JOIN citasmedicas.especialista ON (citasmedicas.cita.idEspecialista = citasmedicas.especialista.idEspecialista AND citasmedicas.cita.idEspecialista = :idEspecialista))