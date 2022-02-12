select count(1) idEspecialista, nombreEspecialista, especialidad, tarifa, maximoDiasAgendables
from especialista
where idEspecialista = :idEspecialista;