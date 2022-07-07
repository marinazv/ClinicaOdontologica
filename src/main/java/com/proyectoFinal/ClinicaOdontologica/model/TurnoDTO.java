package com.proyectoFinal.ClinicaOdontologica.model;

import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Odontologo;
import com.proyectoFinal.ClinicaOdontologica.persistence.entities.Paciente;

import java.util.Date;

public class TurnoDTO {

    private Long id;
    private Date fecha;
    private Paciente paciente;
    private Odontologo odontologo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
