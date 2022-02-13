INSERT INTO paciente(idPaciente, nombrePaciente, cedula) VALUES('1', 'pacienteTest', '123456');
INSERT INTO especialista(idEspecialista, nombreEspecialista, especialidad, tarifa, maximoDiasAgendables) VALUES('1', 'Juan Especi', 'Especialidad ing', '30000', '6');
INSERT INTO cita(idPaciente, idEspecialista, fecha) VALUES('1', '1', '2022-02-18 10:00:00');