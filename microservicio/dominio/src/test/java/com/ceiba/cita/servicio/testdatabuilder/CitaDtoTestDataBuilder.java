package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.dto.DtoCita;

import java.time.LocalDateTime;

public class CitaDtoTestDataBuilder {

    private Long id;
    private LocalDateTime fecha;
    private String nombrePaciente;
    private String cedula;
    private String nombreEspecialista;
    private String especialidad;
    private int tarifa;

    public CitaDtoTestDataBuilder(){
        fecha =  LocalDateTime.of(2022, 3, 3, 15, 0, 0);
        nombrePaciente = "JuanPaciente";
        cedula = "123";
        nombreEspecialista = "PedroEspecialista";
        especialidad = "General";
        tarifa = 33000;
    }

    public CitaDtoTestDataBuilder conId(Long id){
        this.id = id;
        return  this;
    }

    public CitaDtoTestDataBuilder conFecha(LocalDateTime fecha){
        this.fecha = fecha;
        return this;
    }

    public CitaDtoTestDataBuilder conNombrePaciente(String nombrePaciente){
        this.nombrePaciente = nombrePaciente;
        return  this;
    }

    public CitaDtoTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }
    public CitaDtoTestDataBuilder conNombreEspecialista(String nombreEspecialista){
        this.nombreEspecialista = nombreEspecialista;
        return this;
    }

    public CitaDtoTestDataBuilder conEspecialidad(String especialidad){
        this.especialidad = especialidad;
        return this;
    }

    public CitaDtoTestDataBuilder conTarifa(int tarifa){
        this.tarifa = tarifa;
        return this;
    }

    public DtoCita build(){
        return new DtoCita(id, fecha, nombrePaciente, cedula, nombreEspecialista, especialidad, tarifa);
    }
}
