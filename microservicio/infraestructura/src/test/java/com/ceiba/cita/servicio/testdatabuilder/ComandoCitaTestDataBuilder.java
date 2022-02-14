package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.comando.ComandoCita;

import java.time.LocalDateTime;

public class ComandoCitaTestDataBuilder {

    private Long id;
    private Long idPaciente;
    private Long idEspecialista;
    private LocalDateTime fecha;

    public ComandoCitaTestDataBuilder(){
        idPaciente = 1l;
        idEspecialista = 1l;
        fecha = LocalDateTime.of(2022,3,3,9,0);
    }

    public ComandoCitaTestDataBuilder conIdPaciente(Long idPaciente){
        this.idPaciente = idPaciente;
        return this;
    }

    public ComandoCitaTestDataBuilder conIdEspecialista(Long idEspecialista){
        this.idEspecialista = idEspecialista;
        return this;
    }

    public ComandoCitaTestDataBuilder conFecha(LocalDateTime fecha){
        this.fecha = fecha;
        return this;
    }

    public ComandoCita build(){
        return new ComandoCita(id, idPaciente, idEspecialista, fecha);
    }
}