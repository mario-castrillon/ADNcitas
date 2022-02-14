package com.ceiba.especialista.servicio.testdatabuilder;


import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;

import java.util.UUID;

public class ComandoEspecialistaTestDataBuilder {
    private Long idEspecialista;
    private String nombreEspecialista;
    private String especialidad;
    private int tarifa;
    private int maximoDiasAgendables;

    public ComandoEspecialistaTestDataBuilder(){
        nombreEspecialista = UUID.randomUUID().toString();
        especialidad = "especialidad";
        tarifa = 30000;
        maximoDiasAgendables = 3;
    }

    public ComandoEspecialistaTestDataBuilder conNombreEspecialista(String nombreEspecialista){
        this.nombreEspecialista = nombreEspecialista;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conEspecialidad(String especialidad){
        this.especialidad = especialidad;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conTarifa(int tarifa){
        this.tarifa = tarifa;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conMaximoDiasAgendables(int maximoDiasAgendables){
        this.maximoDiasAgendables = maximoDiasAgendables;
        return this;
    }

    public ComandoEspecialista build(){
        return new ComandoEspecialista(idEspecialista, nombreEspecialista, especialidad, tarifa, maximoDiasAgendables);
    }
}
