INSERT INTO paciente(idPaciente, nombrePaciente, cedula) VALUES('1', 'pacienteTest', '123456');
INSERT INTO especialista (nombreEspecialista, especialidad, tarifa, maximoDiasAgendables) VALUES(:nombreEspecialista, :especialidad, :tarifa, :maximoDiasAgendables);
INSERT INTO cita(idPaciente, idEspecialista, fecha) VALUES(:idPaciente, :idEspecialista, :fecha);