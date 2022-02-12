package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.comando.ComandoPaciente;

import java.util.UUID;

public class ComandoPacienteTestDataBuilder {
    private Long idPaciente;
    private String nombrePaciente;
    private String cedula;

    public ComandoPacienteTestDataBuilder(){
        nombrePaciente = UUID.randomUUID().toString();
        cedula = "123";
    }

    public ComandoPacienteTestDataBuilder conNombrePaciente(String nombrePaciente){
        this.nombrePaciente = nombrePaciente;
        return  this;
    }

    public ComandoPacienteTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public ComandoPaciente build(){
        return new ComandoPaciente(idPaciente,nombrePaciente,cedula);
    }
}
